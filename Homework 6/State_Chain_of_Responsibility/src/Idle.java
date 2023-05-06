public class Idle implements StateOfVendingMachine {
    private static Idle instance = null;
    private Idle() {}
    public static Idle getInstance() {
        if (instance == null) instance = new Idle();
        return instance;
    }

    @Override
    public void selectSnack(VendingMachine machine, String snackName) {
        Snack snack = machine.getSnackFromInventoryWithName(snackName);
        if (snack == null) {
            System.out.println("Snack not found");
            return;
        }
        System.out.println("You selected 1 of " + snackName);
        machine.setSelectedSnack(snack);
        machine.setState(WaitingForMoney.getInstance());
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Please select a snack before inserting money");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        System.out.println("Please select a snack before you try to dispense one");
    }
}
