package ru.hackrussia.foodsharing1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AdListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdListAdapter adapter;
    private List<Ad> ads;
    private FloatingActionButton fab;
    private AdDatabase adDB;
    private Ad ad;
    private String id;

    private OnListItemClickListener clickListener = new OnListItemClickListener() {
        @Override
        public void onClick(View v, int position) {
            Intent intent = new Intent(AdListActivity.this, AdActivity.class);
            intent.putExtra("title", ads.get(position).getImg());
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ad);

        adDB = new AdDatabase();

        ads = new ArrayList<>();

        id = getIntent().getExtras().get("id").toString();

        ads.clear();



        createAds();

        //ads = doSignUp(id);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        //performUsers();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fab = (FloatingActionButton) findViewById(R.id.fab);

        adapter = new AdListAdapter(ads, clickListener);
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(v -> {
            //Intent intent = new Intent(AdListActivity.this, AdListActivity.class);
            //startActivity(intent);
        });
    }


    private void performUsers() {
        ads = adDB.getAll();
        adDB.addChangeListener(element -> {
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void createAds(){
        ads.add(new Ad("Суп", "123", "Здравствуйте, дорогие друзья! \n" +
                "Сегодня наша #едабезграниц прошла особенно душевно: горячий тыквенный суп, картофель с грибами (вкуснее чем в ресторане), знаменитые вафли, пряники, печеньки и чай ☕ \n" +
                "\n" +
                "Мы всё чаще слышим от вас добрые слова, это убеждает нас в том, что мы делаем всё правильно! \n" +
                "Приходите по субботам с 15 до 16 на Лиговский 56Б, мы ждём вас на тёплый и уютный обед \uD83D\uDE0A"
                , "id", "17.11.2016", "soup"));


        ads.add(new Ad("Чай и ...", "123",
                "Москва, бываю в центре , пишите в личку)\n" +
                "Каша льняная, просрочена\n" +
                "Специи для заготовок, сроки в норме\n" +
                "Черный кунжут, не пришёлся по вкусу \n" +
                "Чаи:зелёный запечатанная пачка, черный 16 пакетиков+на один разок плодово-ягодный чай с черникой из Карпат \n" +
                "Кэроб\n" +
                "Какао обезжиренный(но вкусный)\n" +
                "Специи для глинтвейна(к сожалению, без палочек корицы)\n" +
                "Желательно в одни руки"
                , "id", "18.11.2016", "teas"));


        ads.add(new Ad("Хлебушек", "123",
                "Отдам даром в Москве 2 буханки бездрожжевого хлеба, ржаного, на закваске. Отдам в подарок лишние 2 буханки первому приехавшему, " +
                        "себе пеку каждую неделю 8 буханок по 500 грамм, а 2 буханки отдаю в подарок. " +
                        "Самовывоз метро Семёновская. Хлеб домашний, сам испёк. \n" +
                        "Состав родниковая вода, мука фирмы \"Чёрный хлеб\" смолота на каменных жерновах, сахар, соль, закваска (мука, вода), сливочное масло. " +
                        "Хлеб приготовлен на опаре, вымешен вручную, хлеб готовится 12 часов. \n" +
                        "В бронь не ставлю, кто первый приедет тот и заберёт. Сразу пишите и звоните и забирайте. 8-963-755-35-88"
                , "id", "18.11.2016", "breads"));

        ads.add(new Ad("Соус", "123",
                "Отдам даром в Москве горчичный соус домашний, жидкий, стеклянная банка 720 мл. Приготовлен вчера, выдержан для остроты двое суток в тепле. " +
                        "Состав: порошок горчицы, огуречный рассол, нерафинированное подсолнечное масло, каменная соль, сахар, " +
                        "лавровый лист, смесь перцев молотых, хмели-сунели, чеснок свежий измельчённый."
                , "id", "18.11.2016", "sauces"));


        ads.add(new Ad("Паста", "123",
                "Озерки - Просвещения, С-Пб, 1/3 арахисовой пасты с кленовым сиропом. Ели, ели, больше не можем) забирать от подьезда сегодня вечером." +
                        " Желающие пишите здесь, свяжусь с Вами через лс. Всем добра!"
                , "id", "19.11.2016", "pasta"));

        ads.add(new Ad("Хлеб", "123",
                "Отдам даром в Москве 2 буханки бездрожжевого хлеба, пшеничного, на закваске. Отдам в подарок лишние 2 буханки первому приехавшему, себе пеку каждую неделю 8 буханок по 500 грамм, а 2 буханки отдаю в подарок." +
                        " Самовывоз метро Семёновская. Хлеб домашний, сам испёк вчера 28.09.2016. 8-963-755-35-88 Юра 4umnik@gmail.com Ватсапп, вибер. \n" +
                        "Здесь в теме писать ничего не надо, в бронь не ставлю, кто первый приедет тот и заберёт. В тему не захожу и не читаю ваши сообщения написанные здесь, сразу пишите, звоните и забирайте. \n" +
                        "Состав родниковая вода, мука фирмы \"Чёрный хлеб\" смолота на каменных жерновах, сахар, соль, закваска (мука, вода), сливочное масло. Хлеб приготовлен на опаре, вымешен вручную, хлеб готовится 12 часов."
                , "id", "19.11.2016", "breads"));

        ads.add(new Ad("Пряник из Крыма", "123",
                "Отдам Спб, метро Международная, пряник, подарили, привезли из Крыма. " +
                        "Он оказался ...некусаемым, может можно как-то размочить, \"шапка\" надломлена, " +
                        "при попытке попробовать. Очень твердый."
                , "id", "19.11.2016", "candys"));

        ads.add(new Ad("Похлебка", "123",
                "Сварила похлёбку из красной фасоли. Ещё даже горячая. Накормлю голодного. Дам с собой в баночке 0,5. Просто много получилось. \n" +
                        "Москва, м Бабушкинская, Сухонская 1, две остановки от метро, пешком это 10 минут. Могу вдогонку дать гренков с чесноком, точнее это я багет чесночный резала и сушила. " +
                        "Фасоль у меня без масла, добавляла только пряности и соль со специями. Если что, дома добавите то, что сочтёте нужным. Я обычно лук и морковку жарю и туда кладу, но сегодня не положила, не до того было. " +
                        "Можно сделать так дома. \n" +
                        "От квартиры, с этажа. Фото, кст, моё."
                , "id", "19.11.2016", "soups2"));

        ads.add(new Ad("Чай кофе...", "123",
                "Отдам в одни руки. Пшено, чуть-чуть кофе, чай. " +
                        "М.Ладожское,ул.Беларусская я\n" +
                        "16."
                , "id", "19.11.2016", "coffee"));

    }

    public void onListChanged(int position) {
        adapter.notifyDataSetChanged();
    }

    private List<Ad> doSignUp(String id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://www.0a.by/json.php?cat=96")
                        //.post(body)
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    Gson gson = new Gson();

                    ads = gson.fromJson(response.body().string(), new TypeToken<ArrayList<Ad>>(){}.getType());
                    Log.d(CategoryListActivity.class.getSimpleName(), ads.get(0).getDate());

                } catch (IOException e) {
                    Log.e(CategoryListActivity.class.getSimpleName(), Log.getStackTraceString(e));
                }
            }
        }).start();
        return ads;
    }
}
