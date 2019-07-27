package greedy;

import greedy.GasStation;

public class TestGasStation {
    public static void main(String[] args){
        GasStation gasStation = new GasStation();
        int[] gas = {2,4,6,8};
        int[] cost = {3,5,7,7};
        gasStation.canCompleteCircuit(gas, cost);
    }
}
