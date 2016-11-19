package ru.hackrussia.foodsharing1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class AdActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;
    private TextView textView;
    private Ad ad;
    private AdDatabase adDB;
    private List<Ad> ads;
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.description);


        title = getIntent().getExtras().get("title").toString();

        if (title.equals("soup")) {


            imageView.setImageResource(R.drawable.soup);


            textView.setText("Здравствуйте, дорогие друзья! \n" +
                    "Сегодня наша #едабезграниц прошла особенно душевно: горячий тыквенный суп, картофель с грибами (вкуснее чем в ресторане), знаменитые вафли, пряники, печеньки и чай ☕ \n" +
                    "\n" +
                    "Мы всё чаще слышим от вас добрые слова, это убеждает нас в том, что мы делаем всё правильно! \n" +
                    "Приходите по субботам с 15 до 16 на Лиговский 56Б, мы ждём вас на тёплый и уютный обед \uD83D\uDE0A");

        } else

        if (title.equals("teas")) {


            imageView.setImageResource(R.drawable.teas);


            textView.setText("Москва, бываю в центре , пишите в личку)\n" +
                    "Каша льняная, просрочена\n" +
                    "Специи для заготовок, сроки в норме\n" +
                    "Черный кунжут, не пришёлся по вкусу \n" +
                    "Чаи:зелёный запечатанная пачка, черный 16 пакетиков+на один разок плодово-ягодный чай с черникой из Карпат \n" +
                    "Кэроб\n" +
                    "Какао обезжиренный(но вкусный)\n" +
                    "Специи для глинтвейна(к сожалению, без палочек корицы)\n" +
                    "Желательно в одни руки");

        }

        if (title.equals("breads")) {


            imageView.setImageResource(R.drawable.breads);


            textView.setText("Отдам даром в Москве 2 буханки бездрожжевого хлеба, ржаного, на закваске. Отдам в подарок лишние 2 буханки первому приехавшему, себе пеку каждую неделю 8 буханок по 500 грамм, а 2 буханки отдаю в подарок. Самовывоз метро Семёновская. Хлеб домашний, сам испёк. \n" +
                    "Состав родниковая вода, мука фирмы \"Чёрный хлеб\" смолота на каменных жерновах, сахар, соль, закваска (мука, вода), сливочное масло. Хлеб приготовлен на опаре, вымешен вручную, хлеб готовится 12 часов. \n" +
                    "В бронь не ставлю, кто первый приедет тот и заберёт. Сразу пишите и звоните и забирайте. 8-963-755-35-88");

        }

        button.setOnClickListener(v -> {
            Toast.makeText(this, "Зарезервировано", Toast.LENGTH_SHORT).show();
        });

    }
}
