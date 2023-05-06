public class WaitingForMoney implements StateOfVendingMachine {
    private static WaitingForMoney instance = null;
    private WaitingForMoney() {}
    public static WaitingForMoney getInstance() {
        if (instance == null) instance = new WaitingForMoney();
        return instance;
    }

    @Override
    public void selectSnack(VendingMachine machine, String snackName) {
        System.out.println("Please wait until current transaction is complete to select another snack");
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        machine.setAmountInserted(machine.getAmountInserted() + amount);
        double snackPrice = machine.getSelectedSnack().getPrice();
        double amountInserted = machine.getAmountInserted();
        if (amountInserted >= snackPrice)
            machine.setState(DispensingSnack.getInstance());
        else
            System.out.print("Please insert more money... Amount needed: $" + snackPrice + ", ");
        System.out.println("Amount inserted so far: $" + amountInserted);
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Please wait until current transaction is complete to dispense snack");
    }
}