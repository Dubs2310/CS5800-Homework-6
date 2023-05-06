import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private StateOfVendingMachine state;
    private SnackDispenseHandler dispenser;
    private List<Snack> inventory;

    private Snack selectedSnack = null;
    private double amountInserted = 0;

    public VendingMachine() {
        state = Idle.getInstance();
        dispenser = new Coke(new Pepsi(new Cheetos(new Doritos(new KitKat(new Snickers(null))))));
        inventory = new ArrayList<>();
    }

    public void setState(StateOfVendingMachine state) {
        this.state = state;
    }

    public SnackDispenseHandler getDispenser() {
        return dispenser;
    }

    public void addSnackToInventory(Snack snack) { inventory.add(snack); }

    public Snack getSnackFromInventoryWithName(String snackName) {
        for (Snack snack: inventory)
            if (snack.getName().equalsIgnoreCase(snackName))
                return snack;
        return null;
    }

    public Snack getSelectedSnack() {
        return selectedSnack;
    }

    public void setSelectedSnack(Snack selectedSnack) {
        this.selectedSnack = selectedSnack;
    }

    public double getAmountInserted() {
        return amountInserted;
    }

    public void setAmountInserted(double amountInserted) {
        this.amountInserted = amountInserted;
    }

    public void selectSnack(String snackName) {
        state.selectSnack(this, snackName);
    }

    public void insertMoney(double amount) {
        state.insertMoney(this, amount);
    }

    public void dispenseSnack() {
        state.dispenseSnack(this);
    }
}
