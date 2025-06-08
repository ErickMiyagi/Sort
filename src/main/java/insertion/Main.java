package insertion;

public class Main {
    public static void main(String[] args) {
        int[] vetor = {5, 3, 4, 2, 8, 1, 6, 7};

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

        int[] vetor2 = {5, 3, 4, 2, 8, 1, 6, 7};

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

        int[] vetor3 = {5, 3, 4, 2, 8, 1, 6, 7};

        System.out.println();
        System.out.println("Vetor Normal: ");
        for (int i : vetor3){
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Quick Sort: ");
        particiona(vetor3, 0, vetor3.length - 1);

        for (int i : vetor3){
            System.out.print(" " + i);
        }
        System.out.println();

        int[] vetor4 = {5, 3, 4, 2, 8, 1, 6, 7};

        System.out.println();
        System.out.println("Vetor Normal: ");
        for (int i : vetor4){
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("Quick Sort V2: ");
        particionaV2(vetor4, 0, vetor4.length - 1);

        for (int i : vetor4){
            System.out.print(" " + i);
        }
        System.out.println();

        System.out.println("Busca binária possui valor 5: ");
        System.out.println(binarySearch(vetor4, 5));

        System.out.println("Busca binária não possui valor: ");
        System.out.println(binarySearch(vetor4, 10));

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

    public static void particiona(int[] v, int indInicio, int indFim) {
        int i = indInicio;
        int j = indFim;
        int pivo = v[(indInicio + indFim) / 2];

        while (i <= j) {
            while (v[i] < pivo) {
                i++;
            }
            while (v[j] > pivo) {
                j--;
            }
            if (i <= j) {
                int temp = v[i];
                v[i] = v[j];
                v[j] = temp;
                i++;
                j--;
            }
        }

        if (indInicio < j) {
            particiona(v, indInicio, j);
        }
        if (i < indFim) {
            particiona(v, i, indFim);
        }
    }

    public static void particionaV2(int[] v, int indInicio, int indFim){
        int i = indFim;
        int pivo = v[indFim];

        for (int j = indFim - 1; j >= indInicio; j--) {
            if(v[j] > pivo){
                i--;
                int temp = v[i];
                v[i] = v[j];
                v[j] = temp;
            }
        }
        int temp = v[indFim];
        v[indFim] = v[i];
        v[i] = temp;

        if(indInicio < i - 1){
            particionaV2(v, indInicio, i - 1);
        }
        if(i + 1 < indFim){
            particionaV2(v, i + 1, indFim);
        }
    }

    public static int binarySearch(int[] vetor, int x){
        int inicio = 0;
        int fim = vetor.length - 1;
        int meio;

        while (inicio <= fim){
            meio = (inicio + fim) / 2;

            if (x == vetor[meio]){
                return meio;
            } else if (x > vetor[meio]){
                inicio = meio + 1;
            } else if(x < vetor[meio]){
                fim = meio - 1;
            }
        }
        return -1;
    }
}
