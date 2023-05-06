public abstract class SnackDispenseHandler {
    private SnackDispenseHandler next;

    public SnackDispenseHandler(SnackDispenseHandler next) {
        this.next = next;
    }

    public void dispenseSnack(VendingMachine machine) {
        if (next != null)
            next.dispenseSnack(machine);
    }
}
