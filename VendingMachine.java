/**
 *
* This is an object class name VendingMachine.This class has some private variables and void methods.
* Actually this is the brain of Vending Machine. All feature of Vending Machine what it perform and how?
* include in the class.
* @author Satinder Singh,000824885
 **/
public class VendingMachine {

    /* This stores name of the product and it is private  **/
    private String productName ;
    /* Price of product may be in decimal values that's why data type double  **/
    private double productPrice;
    /* This means how user have money right now **/
    private double credit ;
    /* vendingNumber means serial number of our machine and productQuantity how many left in stocks **/
    private int    productQuantity,vendingNumber;
    /* HOw much user spent on vending machine **/
    private double vendMoney;

    /**
     *
     * @param vendingNumber Machine Number
     */
    public void setVendingNumber(int vendingNumber) {
        this.vendingNumber = vendingNumber;
    }

    /**
     *
     * @return productQuantity How many stocks in vending Machine
     */
    public int getProductQuantity() {
        return productQuantity;
    }

    /**
     *
     * @param productQuantity productQuantity
     */
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    /**
     *
     * @return credit
     */
    public double getCredit() {
        return credit;
    }

    /**
     *
     * @param credit credit
     */
    public void setCredit(double credit) {
        this.credit = credit;
    }

    /**
     *
     * @return vendMoney
     * Actually it is a getter method which gives how much user spent money on particular machine
     **/
    public double getVendMoney() {
        return vendMoney;
    }


    /**
     *
     * @param vendMoney
     * It takes this param and store in this class variable vendMoney
     **/
    public void setVendMoney(double vendMoney) {
        this.vendMoney = vendMoney;
    }

    /**
     *
     * @return productName
     * Actually it is a getter method
     **/
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @return productPrice
     * Actually it is a getter method which return productPrice
     **/

    public double getProductPrice() {
        return productPrice;
    }

    /**
     *
     * @param productPrice price of the product
     * It takes this param and store in this class variable productPrice
     **/

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    /**
     *
     * @param productName name of the product
     * It takes this param and store in this class variable productName
     **/
    public void setProductName(String productName) {
        this.productName = productName;
    }


    /**
     *
     * Add inserted_money to credit. It is void type.
     * @param inserted_money how much user insert money into machine
     */
    void addMoney(double inserted_money){
        credit +=  inserted_money;
    }

    /**
     *
     * It minus x from cre_dit and stroe into credit.Also,print some information.
     * @param credit how much machine have in it
     * @param x how much user wants
     * */
    void change(double credit, double x){
        System.out.println("Your change processor is done and here it is your amount: "+x);
        this.credit = credit - x;
    }

    /**
     * c variable of double type is declared
     * c stores the amount which is comes from how much quantity user wants multiply by price of one product
     * vendMoney also store c which tells how much user spent on particular machine
     *  After Buying form the machine it change the credit amount by deducing y by c
     *  It also put a change in product quantity
     * @param qity How much quantity user wants of particular product
     * @param y price of particular product
     */
    void vend(int qity,double y) {
        double c = productPrice*qity;
        vendMoney = c;
        credit = y-c;
        productQuantity = productQuantity - qity;
        System.out.println("Enjoy!!!!!!!");
    }

    /**
     * Print a statement of whole information about vending machine. What it contains , price, how much left, unused credit and vend money
     * @param other while object of this class
     */
    void toString(VendingMachine other)
    {
        System.out.println(other.vendingNumber+" Vending Machine contains: " + other.productQuantity + " "+other.productName + " Price : " + other.productPrice);
        System.out.printf("\tUnused Credit: %.2f", other.credit);
        System.out.printf("\n\tTotal amount of money vended: %.2f" , other.vendMoney);
        System.out.println();
    }
}
