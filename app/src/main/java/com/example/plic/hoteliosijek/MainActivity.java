package com.example.plic.hoteliosijek;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.plic.hoteliosijek.model.Accommodation;
import com.example.plic.hoteliosijek.adapter.AccommodationAdapter;
import com.example.plic.hoteliosijek.utils.DatabaseHandler;
import com.example.plic.hoteliosijek.utils.TypefaceSpan;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpannableString s = new SpannableString("Hoteli Osijek");
        s.setSpan(new TypefaceSpan(this, "MyriadPro-Regular.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        setTitle(s);

        DatabaseHandler db = new DatabaseHandler(this);

        if(db.emptyTable()) {
            db.addAccommodation(new Accommodation("Hotel Silver", "Martina Divalta 84", "31000 Osijek",
                    "Hotel Silver je obiteljski, luksuzno uređeni hotel smješten u neposrednoj blizini Gradskog vrta, sportske dvorane, zatvorenih bazena, shoping centra, te samo 2.000 metara udaljen od središta grada.",
                    "http://hotel-silver.hr/img/gal/0004.jpg", "http://hotel-silver.hr/img/gal/0005.jpg,http://hotel-silver.hr/img/gal/0016.jpg,http://hotel-silver.hr/img/gal/0026.jpg",
                    3.5f));
            db.addAccommodation(new Accommodation("Hotel Osijek", "Šamačka 4", "31000 Osijek",
                    "U centru Osijeka, u srcu pješačke zone grada smješten je hotel Osijek, na najdužoj i najljepšoj riječnoj šetnici u Hrvatskoj. Hotel Osijek ima 140 soba i 7 apartmana. Sve su smještajne jedinice prema kvaliteti kategorizirane kao classic, superior i deluxe.",
                    "http://www.hotelosijek.hr/files/g/1-0/710x445-5/eksterijer-prilaz-hotelu.jpg", "http://www.hotelosijek.hr/files/g/1-0/710x445-5/janko.jpg,http://www.hotelosijek.hr/files/g/1-0/710x445-5/superior-twin-novo.jpg,http://www.hotelosijek.hr/files/g/1-0/710x445-5/restoran-broj-2.jpg",
                    4f));
            db.addAccommodation(new Accommodation("Hotel Central", "Trg A. Starčevića 6", "31000 Osijek",
                    "Savršena lokacija, ljubazno osoblje, ugodan smještaj samo je dio onoga što Vam ovaj hotel može ponuditi. Posjetiti Osijek poslovno ili turistički svakako će biti jedno nezaboravno putovanje. Kulturno blago ovoga kraja, šarm slavonske ravnice, flora i fauna, gastronomska ponuda, toplina i gostoljubivost ovdašnjih ljudi neće Vas ostaviti ravnodušnim.",
                    "http://www.hotel-central-os.hr/img-content/galerija1-prva.jpg", "http://www.hotel-central-os.hr/img-content/galerija1.jpg,http://www.hotel-central-os.hr/img-content/galerija4.jpg,http://www.hotel-central-os.hr/img-content/galerija10.jpg",
                    4f));
            db.addAccommodation(new Accommodation("Hotel Drava", "Ivana Gundulića 25a", "31000 Osijek",
                    "Hotel Drava smješten je na jedinstvenom položaju u središtu grada. Samo nekoliko minuta od autobusnog i željezničkog kolodvora, u neposrednoj blizini glavnih turističkih atrakcija i gradskih znamenitosti.",
                    "http://www.hotel-drava.com/wp-content/uploads/IMG_3431.jpg", "http://www.hotel-drava.com/wp-content/uploads/IMG_5123.jpg,http://www.hotel-drava.com/wp-content/uploads/IMG_4952.jpg,http://www.hotel-drava.com/wp-content/uploads/IMG_3298.jpg",
                    4.8f));
            db.addAccommodation(new Accommodation("Hotel Waldinger", "Županijska ulica 8", "31000 Osijek",
                    "Hotel Waldinger prvi je hotel sa četiri zvjezdice u Osijeku, a sastavni mu je dio i Depadansa Waldinger s tri zvjezdice. Smješten je u Županijskoj ulici, na najljepšoj lokaciji u samom središtu grada. Stogodišnja secesijska zgrada Hotela Waldinger zaštićena je kao kulturni i ambijentalni spomenik koju je projektirao i reljefnom ornametikom oplemenio arhitekt i kipar Antun Slaviček, umjetnik osječke secesije.",
                    "http://waldinger.hr/wp-content/uploads/2015/03/home-featured-hotel-Waldinger.jpg", "http://waldinger.hr/wp-content/uploads/2015/03/home-featured-reception.jpg,http://waldinger.hr/wp-content/uploads/2015/03/home-featured-deluxe-room.jpg,http://waldinger.hr/wp-content/uploads/2015/06/Taverna0001.jpg",
                    4.4f));
            db.addAccommodation(new Accommodation("Hotel Millennium", "Kralja Petra Svačića 12", "31000 Osijek",
                    "Hotel Millennium Osijek je moderan hotel smješten blizu centra grada i u blizini stare gradske jezgre Tvrđe. Osim besprijekorne usluge i odlično opremljenog prostora nudi kvalitetan i ugodan smještaj za modernog poslovnog ili turističkog putnika.",
                    "http://www.hotel-millennium.hr/images/hotelmillennium.jpg", "http://www.hotel-millennium.hr/images/gal17m.jpg,http://www.hotel-millennium.hr/images/gal2m.jpg,http://www.hotel-millennium.hr/images/gal8m.jpg",
                    3.7f));
            db.addAccommodation(new Accommodation("Hotel Vila Ariston", "Kačićeva 6", "31000 Osijek",
                    "U Vila Ariston nudimo Vam atmosferu vlastitog doma i zato kažemo da je to Vaš dom daleko od kuće. Naše ljubazno osoblje pružit ce Vam opuštajuću, šarmantno-diskretnu atmosferu, Vaš boravak učiniti jedinstvenim doživljajem.",
                    "http://www.hotelaristonosijek.hr/images/screenshots/big/b-abstract-vector.jpg", "http://www.hotelaristonosijek.hr/images/screenshots/big/b-line-icons.jpg,http://www.hotelaristonosijek.hr/images/screenshots/big/b-embossed-paper.jpg,http://www.hotelaristonosijek.hr/images/screenshots/big/b-judah.jpg",
                    3.9f));
            db.addAccommodation(new Accommodation("Hotel Zelenkrov", "Osječka 167", "31431 Čepin",
                    "Hotel Zelenkrov sa svojom kavanom, restoranom te kongresno-banketnom dvoranom čine idealno mjesto, bilo da se radi o poslovnim sastancima ili prigodnim domjencima, a sve uz vrhunsku i efikasnu uslugu",
                    "http://www.zelenkrov.hr/images/slike/hotel/hotel_008.jpg", "http://www.zelenkrov.hr/images/slike/sobe/001.JPG,http://www.zelenkrov.hr/images/slike/sobe/013.jpg,http://www.zelenkrov.hr/images/slike/sobe/006.JPG",
                    3.5f));
            db.addAccommodation(new Accommodation("Fitea", "Srijemska 27", "31000 Osijek",
                    "Pansion Komfor „FITEA“ ***  je novoizgrađeni objekat vrhunski opremljen (nivo hotela sa 3 zvjezdice) i predstavlja nastavak obiteljske tradicije započete radom prvog Privatnog smještaja „Fitea“ *** u gradu Osijeku.",
                    "http://www.fitea.hr/galerija/recepcija/Fitea-objekt-1.jpg", "http://www.fitea.hr/galerija/caffe/100B1590.JPG,http://www.fitea.hr/galerija/sobe/IMG_1434.jpg,http://www.fitea.hr/galerija/restoran/100_1624.JPG",
                    4.5f));
            db.addAccommodation(new Accommodation("Zoo Hotel", "Sjevernodravska obala bb", "31000 Osijek",
                    "HOTEL ZOO je jedini hotel sa 4 zvjezdice ekskluzivno smješten tik uz lijevu obalu rijeke Drave, u neposrednoj blizini čarobno mirne okoline zelenila, vode i dugih šetnica.Idealna pozicija čini ovaj hotel mjestom gdje svaki gost može pronaći nešto za sebe, bilo to u smislu aktivnog odmora ili željenog mira i opuštanja nakon napornog tjedna.",
                    "http://www.zoo-hotel.hr/wp-content/uploads/2015/03/hotel1.jpg", "http://www.zoo-hotel.hr/wp-content/gallery/test1/AVF_8405-1.jpg,http://www.zoo-hotel.hr/wp-content/uploads/2015/03/about.jpg,http://www.zoo-hotel.hr/wp-content/gallery/lobby-bar/web2.jpg",
                    4.1f));
        }


        // Reading all accommodations
        List<Accommodation> acc_list = db.getAllAccommodations();

        ListView accListView = (ListView) findViewById(R.id.accListView);
        AccommodationAdapter acc_adapter = new AccommodationAdapter(this, acc_list);
        accListView.setAdapter(acc_adapter);

        accListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b=new Bundle();
                b.putString("Accommodation", new Gson().toJson((Accommodation) parent.getItemAtPosition(position)));
                Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                i.putExtras(b);
                startActivity(i);
            }
        });

    }
}
