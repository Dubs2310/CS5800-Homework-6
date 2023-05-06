public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.addSnackToInventory(new Snack("Coke", 5, 1.25));
        machine.addSnackToInventory(new Snack("Pepsi", 3, 1.50));
        machine.addSnackToInventory(new Snack("Cheetos", 2, 1.75));
        machine.addSnackToInventory(new Snack("Doritos", 4, 1.50));
        machine.addSnackToInventory(new Snack("KitKat", 0, 1.00));
        machine.addSnackToInventory(new Snack("Snickers", 1, 2.00));

        // selecting a snack that doesn't exist
        machine.selectSnack("Pringles");
        System.out.println();

        // trying to insert money or dispensing before selecting snack
        machine.insertMoney(2.5);
        machine.dispenseSnack();
        System.out.println();

        // selecting one Snickers
        machine.selectSnack("Snickers");
        System.out.println();

        // trying to select another snack or dispensing while waiting for Snickers money
        machine.selectSnack("Pepsi");
        machine.dispenseSnack();
        System.out.println();

        // inserting money less than Snickers price and attempting to dispense
        machine.insertMoney(0.5);
        machine.dispenseSnack();
        System.out.println();

        // inserting more money
        machine.insertMoney(2.0);
        System.out.println();

        // trying to select a snack or insert more money while Snickers is dispensing
        machine.selectSnack("Pepsi");
        machine.insertMoney(0.7);
        System.out.println();

        // dispensing Snickers
        machine.dispenseSnack();
        System.out.println();

        // trying to insert money and dispense snack again
        machine.insertMoney(1.3);
        machine.dispenseSnack();
        System.out.println();

        // selecting another Snickers, inserting money and dispensing it again
        machine.selectSnack("Snickers");
        machine.insertMoney(2.0);
        machine.dispenseSnack();
        System.out.println();

        // selecting a Pepsi, inserting money and dispensing it (x4)
        for (int i = 0; i < 4; ++i) {
            machine.selectSnack("Pepsi");
            machine.insertMoney(1.5);
            machine.dispenseSnack();
            System.out.println();
        }
    }
}