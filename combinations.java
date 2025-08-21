import java.util.*;


public class combinations{
    public static void main(String[] args) {
        BinaryCombo combo = new BinaryCombo(4);
        combo.run();
    }
}


class BinaryCombo implements Runnable{
    int n;
    BinaryCombo(int n){
        this.n = n;
    }
    @Override
    public void run(){
        System.out.println("INPUTS");
        List<List<Integer>> inputs = getInputs();
        for (List<Integer> input : inputs){
            System.out.println(input.toString());
        }
        System.out.println("OUTPUTS");
        List<List<Integer>> outputs = getOutputs();
        for (List<Integer> output : outputs){
            System.out.println(output.toString());
        }
    }
    public List<List<Integer>> getInputs(){
        return getCombos(n);
    }
    public List<List<Integer>> getOutputs(){
        return getCombos((int)Math.pow(n, 2));
    }
    
    private List<List<Integer>> getCombos(int n){
        //there are 2^n inputs, each either 0, 1
        class Helper{
            List<List<Integer>> inputs = new LinkedList<>();

            public void help(List<Integer> path){
                if (path.size() == n) {
                    inputs.add(new LinkedList<>(path));
                    return;
                }
                for(int i = 0; i < 2; i ++){
                    path.add(i);
                    help(path);
                    path.remove(path.size()-1);
                }
            }
        }

        Helper helper = new Helper();
        helper.help(new LinkedList<>());

        return helper.inputs;
    }
}