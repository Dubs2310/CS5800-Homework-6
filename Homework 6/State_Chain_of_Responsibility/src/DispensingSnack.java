public class DispensingSnack implements StateOfVendingMachine {
    private static DispensingSnack instance = null;
    private DispensingSnack() {}
    public static DispensingSnack getInstance() {
        if (instance == null) instance = new DispensingSnack();
        return instance;
    }

    @Override
    public void selectSnack(VendingMachine machine, String snackName) {
        System.out.println("Please wait until the current snack has finished dispensing before selecting another");
    }

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Please wait until the current snack has finished dispensing before inserting more money");
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        machine.getDispenser().dispenseSnack(machine);
    }
}