import utilities.ProvidePadding;

public class Food {
    String fname ;
    int price ;
    int fid;
    String category;

    public Food(String fname, String category, int price) {
        this.fname = fname;
        this.category = category;
        this.price = price;
    }
    public Food(String fname, String category, int price,int fid) {
        this.fname = fname;
        this.category = category;
        this.price = price;
        this.fid = fid;
    }

    public Food(Food f) {
        this.fid = f.fid;
        this.fname = f.fname;
        this.price = f.price;
        this.category = f.category;
    }
    public String toString() {
        String str = ProvidePadding.paddBoth(String.valueOf(this.fid),10,' ');
        str += ProvidePadding.paddLeft(fname, 30, ' ');
        str += ProvidePadding.paddBoth("$"+this.price, 20, ' ');
        return str;
    }
}


