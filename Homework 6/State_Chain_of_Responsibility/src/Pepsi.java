public class Pepsi extends SnackDispenseHandler {
    public Pepsi(SnackDispenseHandler next) {
        super(next);
    }

    public void dispenseSnack(VendingMachine machine) {
        Snack snack = machine.getSelectedSnack();

        if (!snack.getName().equalsIgnoreCase("Pepsi")) {
            super.dispenseSnack(machine);
            return;
        }

        double change = machine.getAmountInserted();
        if (snack.getQuantity() > 0) {
            change -= snack.getPrice();
            snack.decrementQuantity();
            System.out.print("Enjoy your Pepsi... ");
        } else {
            System.out.print("Sorry, looks like we're out of Pepsi... ");
        }

        System.out.println("Here's your change: $" + change);
        machine.setState(Idle.getInstance());
        machine.setSelectedSnack(null);
        machine.setAmountInserted(0);
    }
}
