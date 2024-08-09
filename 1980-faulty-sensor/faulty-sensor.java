class Solution {
    public int badSensor(int[] sensor1, int[] sensor2) {
        for(int i = 0; i < sensor1.length - 1; i++){
            if(sensor1[i] != sensor2[i]){
                boolean isSensor1 = true;
                for(int j = i + 1; j < sensor1.length; j++){
                    if(sensor1[j - 1] != sensor2[j]) {
                        isSensor1 = false;
                        break;
                    }
                }

                boolean isSensor2 = true;
                for(int j = i + 1; j < sensor1.length; j++){
                    if(sensor2[j - 1] != sensor1[j]) {
                        isSensor2 = false;
                        break;
                    }
                }
                if(isSensor1 && isSensor2) return -1;
                return isSensor1 ? 1 : 2;
            }
        }
        return -1;
    }
}