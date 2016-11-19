package ru.hackrussia.foodsharing1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class AdActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;
    private TextView textView;
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

        }

        else if (title.equals("teas")) {
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

        else if (title.equals("breads")) {
            imageView.setImageResource(R.drawable.breads);
            textView.setText("Отдам даром в Москве 2 буханки бездрожжевого хлеба, ржаного, на закваске. Отдам в подарок лишние 2 буханки первому приехавшему, " +
                    "себе пеку каждую неделю 8 буханок по 500 грамм, а 2 буханки отдаю в подарок. " +
                    "Самовывоз метро Семёновская. Хлеб домашний, сам испёк. \n" +
                    "Состав родниковая вода, мука фирмы \"Чёрный хлеб\" смолота на каменных жерновах, сахар, соль, закваска (мука, вода), сливочное масло. Хлеб приготовлен на опаре, вымешен вручную, хлеб готовится 12 часов. \n" +
                    "В бронь не ставлю, кто первый приедет тот и заберёт. Сразу пишите и звоните и забирайте. 8-963-755-35-88");
        }

        else if (title.equals("sauces")) {
            imageView.setImageResource(R.drawable.sauces);
            textView.setText("Отдам даром в Москве горчичный соус домашний, жидкий, стеклянная банка 720 мл. Приготовлен вчера, выдержан для остроты двое суток в тепле." +
                    " Состав: порошок горчицы, огуречный рассол, нерафинированное подсолнечное масло, " +
                    "каменная соль, сахар, лавровый лист, смесь перцев молотых, хмели-сунели, чеснок свежий измельчённый.");

        }

        else if (title.equals("pasta")) {
            imageView.setImageResource(R.drawable.pasta);
            textView.setText("Озерки - Просвещения, С-Пб, 1/3 арахисовой пасты с кленовым сиропом. Ели, ели, больше не можем) " +
                    "забирать от подьезда сегодня вечером. " +
                    "Желающие пишите здесь, свяжусь с Вами через лс. Всем добра!");
        }

        else if (title.equals("breads")) {
            imageView.setImageResource(R.drawable.breads);
            textView.setText("Отдам даром в Москве 2 буханки бездрожжевого хлеба, пшеничного, на закваске. Отдам в подарок лишние 2 буханки первому приехавшему, себе пеку каждую неделю 8 буханок по 500 грамм, а 2 буханки отдаю в подарок." +
                    " Самовывоз метро Семёновская. Хлеб домашний, сам испёк вчера 28.09.2016. 8-963-755-35-88 Юра 4umnik@gmail.com Ватсапп, вибер. \n" +
                    "Здесь в теме писать ничего не надо, в бронь не ставлю, кто первый приедет тот и заберёт. В тему не захожу и не читаю ваши сообщения написанные здесь, сразу пишите, звоните и забирайте. \n" +
                    "Состав родниковая вода, мука фирмы \"Чёрный хлеб\" смолота на каменных жерновах, сахар, соль, закваска (мука, вода), сливочное масло. Хлеб приготовлен на опаре, вымешен вручную, хлеб готовится 12 часов.");
        }

        else if (title.equals("candys")) {
            imageView.setImageResource(R.drawable.candys);
            textView.setText("Отдам Спб, метро Международная, пряник, подарили, привезли из Крыма. " +
                    "Он оказался ...некусаемым, может можно как-то размочить, \"шапка\" надломлена, " +
                    "при попытке попробовать. Очень твердый.");
        }

        else if (title.equals("soups2")) {
            imageView.setImageResource(R.drawable.soups2);
            textView.setText("Забронировано. \n" +
                    "Сварила похлёбку из красной фасоли. Ещё даже горячая. Накормлю голодного. Дам с собой в баночке 0,5. Просто много получилось. \n" +
                    "Москва, м Бабушкинская, Сухонская 1, две остановки от метро, пешком это 10 минут. Могу вдогонку дать гренков с чесноком, точнее это я багет чесночный резала и сушила. " +
                    "Фасоль у меня без масла, добавляла только пряности и соль со специями. Если что, дома добавите то, что сочтёте нужным. Я обычно лук и морковку жарю и туда кладу, но сегодня не положила, не до того было. " +
                    "Можно сделать так дома. \n" +
                    "От квартиры, с этажа. Фото, кст, моё.");
        }

        else if (title.equals("coffee")) {
            imageView.setImageResource(R.drawable.coffee);
            textView.setText("Отдам в одни руки. Пшено, чуть-чуть кофе, чай. " +
                    "М.Ладожское,ул.Беларусская я\n" +
                    "16.");
        }

            button.setOnClickListener(v -> {
                Toast.makeText(this, "Зарезервировано", Toast.LENGTH_SHORT).show();
            });

    }
}
