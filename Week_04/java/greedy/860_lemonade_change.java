class Solution {
    public boolean lemonadeChange(int[] bills) {

        int five = 0, ten = 0;

        for(int i=0; i<bills.length; i++) {
            switch(bills[i]) {
                case 5: {
                    five ++;
                    break;
                }
                case 10: {
                    if( five == 0) return false;
                    else {
                        five --;
                        ten ++;
                    }
                    break;
                }
                case 20: {
                    if( ten >= 1 && five >= 1) {
                        ten --;
                        five --;
                    } else if(ten == 0 && five >= 3){
                        five -= 3;
                    } else {
                        return false;
                    }
                    break;
                }

            }
            System.out.println("bill:" + bills[i] + "|" + "5 * " + five + " + " + "10 * " + ten );
        }

        return true;

    }
}
