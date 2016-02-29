        public static void countSort(int[] array, int range){  
            if (array.length <= 1) {  
                return;  
            }  
  
            int[] countArray = new int[range + 1];  
            for (int i = 0; i < array.length; i++) {  
                int value = array[i];  
                if (value < 0 || value > range) {  
                    throw new Exception("array element overflow range.");  
                }  
                countArray[value] += 1;  
            }  
  
            for (int i = 1; i < countArray.length; i++) {  
                countArray[i] += countArray[i - 1];  
            }  
  
            int[] temp = new int[array.length];  
            for (int i = array.length - 1; i >= 0; i--) {  
                int value = array[i];  
                int position = countArray[value] - 1;  
  
                temp[position] = value;  
                countArray[value] -= 1;  
            }  
  
            for (int i = 0; i < array.length; i++) {  
                array[i] = temp[i];  
            }  
        }  