package insertion;

public class Main {
    public static void main(String[] args) {
        int[] vetor = {12, 11, 13, 5, 6};

        System.out.println("Vetor normal: ");
        for (int v : vetor){
            System.out.print(" " + v);
        }

        System.out.println();
        insertionSort(vetor);

        System.out.println("Insertion Sort: ");
        for (int v : vetor){
            System.out.print(" " + v);
        }

        int[] vetor2 = {19,20,1,23,29,10,14,123,12,2};

        System.out.println();
        System.out.println("Vetor Normal: ");
        for (int i : vetor2){
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Merge Sort: ");
        mergeSortRecursivo(0, vetor2.length, vetor2);

        for (int i : vetor2){
            System.out.print(" " + i);
        }
        System.out.println();

    }

    public static void insertionSort(int[] v){
        int j,x;
        for (int i = 1; i < v.length; i++) {
            x = v[i];
            j = i - 1;

            while (j >= 0 && v[j] > x){
                v[j + 1] = v[j];
                j = j - 1;
            }
            v[j + 1] = x;
        }
    }

    public static void mergeSortRecursivo(int p, int r, int[] v){
        if(p < r - 1){
            int q = (p + r) / 2;
            mergeSortRecursivo(p, q, v);
            mergeSortRecursivo(q, r, v);
            mergeSortIntercala(p, q, r, v);
        }
    }

    public static void mergeSortIntercala(int p, int q, int r, int[] v){
        int i = p;
        int j = q;
        int k = 0;

        int[] w = new int[r - p];

        while (i < q && j < r){
            if (v[i] <= v[j]){
                w[k++] = v[i++];
            } else {
                w[k++] = v[j++];
            }
        }

        while (i < q){
            w[k++] = v[i++];
        }

        while (j < r){
            w[k++] = v[j++];
        }

        for (i = p; i < r; i++){
            v[i] = w[i - p];
        }
    }

    public static void quickSort()
}
