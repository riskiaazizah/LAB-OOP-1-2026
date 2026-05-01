package tuprak5.soal2;

abstract class PerangkatElektronik {
    String merk;
    float dayaListrik;

    PerangkatElektronik(String merk, float dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    abstract void cekFungsi();

    void infoPower() {
        System.out.println("Perangkat " + merk + " sedang menyedot daya sebesar " + this.dayaListrik + "Watt");
    }
}

interface IinteraksiInternet {
    void hubungkanWifi();
}

interface IkontrolSuara {
    void prosesPerintah(String perintah);
}

class SmartLamp extends PerangkatElektronik implements IkontrolSuara {
    SmartLamp (String merk, float dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("Barang " + super.merk + " berfungsi!");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equals("NYALA")) {
            System.out.println("Lampu berpijar!");
        }else {
            System.out.println("Lampu mati");
        }
    }
}

class SmartCCTV extends PerangkatElektronik implements IinteraksiInternet {
    SmartCCTV (String merk, float dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("Barang " + super.merk + " berfungsi!");
    }

    @Override
    public void hubungkanWifi() {
        System.out.println("Mengirim data ke server...");        
    }
}

class SmartSpeaker extends PerangkatElektronik implements IinteraksiInternet, IkontrolSuara {
    SmartSpeaker (String merk, float dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    void cekFungsi() {
        System.out.println("Barang " + super.merk + " berfungsi!");
    }

    @Override
    public void prosesPerintah(String perintah) {
         if (perintah.equals("NYALA")) {
            System.out.println("Speaker menyala!");
        }else {
            System.out.println("Speaker mati!");
        }
    }

    @Override
    public void hubungkanWifi() {
        System.out.println("Mengirim data ke server...");
    } 
}

// compile 1 = javac tuprak5/soal2/PerangkatElektronik.java
//compile 2 = java tuprak5.soal2.Main

class Main {
    public static void main(String[] args) {
        SmartLamp philips = new SmartLamp("Philips", 15);

        SmartCCTV hikvision = new SmartCCTV("hikvision", 80);

        SmartSpeaker dbe = new SmartSpeaker("dBE", 40);
        dbe.infoPower();
        dbe.cekFungsi();
        dbe.prosesPerintah("fh");
        dbe.hubungkanWifi();
        System.out.println("\n");

        philips.infoPower();
        philips.cekFungsi();
        philips.prosesPerintah("hf");
        System.out.println("\n");

        hikvision.infoPower();
        hikvision.cekFungsi();
    

    }    
}
