/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

/**
 *
 * @author Mario
 */
public class TesteOrd {
    
    public int [] bubbleSort(int [] vetor){
        
        // for utilizado para controlar a quantidade de vezes que o vetor será ordenado.
        for(int i = 0; i < vetor.length - 1; i++) {
          // for utilizado para ordenar o vetor.
            for(int j = 0; j < vetor.length - 1 - i; j++) {
            /* Se o valor da posição atual do vetor for maior que o proximo valor,
              então troca os valores de lugar no vetor. */
                if(vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }  
        }
        
        return vetor;
    }
    public int [] mergeSort(int [] vetor){
        int tamanho = vetor.length;
        /* Variavel utilizada para percorrer o vetor. 
        Inicializa com 1 para indicar que o vetor tenha pelo menos 1 elemento. */
        int elementos = 1;
        /* Variaveis utilizadas para marcar o inicio, meio e fim do vetor. */
        int inicio, meio, fim;

        /* Percorre os elementos do vetor até chegar no fim do vetor. */
        while(elementos < tamanho) {
          /* Aponta o inicio do vetor. */
          inicio = 0;

          /* Percorre o vetor do inicio + quantidade de elementos ja percorrido, 
            até o tamanho do vetor. */
            while(inicio + elementos < tamanho) {
                /* Guarda a posição do meio do vetor que será ordenado. */
                meio = inicio + elementos;
                /* Guarda a posição final do vetor que será ordenado. */
                fim = inicio + 2 * elementos;

                /* Caso o fim fique com um tamanho maior, que o tamanho do vetor,
                 então faz o fim ter o mesmo tamanho que o tamanho do vetor. */
                if(fim > tamanho)
                  fim = tamanho;

                /* Chama o método que faz a intercalação dos valores
                  ordenados do vetor. */
                vetor = intercala(vetor, inicio, meio, fim);

                /* Faz o inicio do vetor ser igual ao fim. */
                inicio = fim;
            }

          /* Percorre o vetor dobrando a quantidade de itens ja ordenados. */
        elementos = elementos * 2;     
        }
        return vetor;
    }
        
    public int [] intercala(int[] vetor, int inicio, int meio, int fim) {
        /* Vetor utilizado para guardar os valors ordenados. */
        int novoVetor[] = new int[fim - inicio];
        /* Variavel utilizada para guardar a posicao do inicio do vetor. */
        int i = inicio;
        /* Variavel utilizada para guardar a posição do meio do vetor. */
        int m = meio;
        /* Variavel utilizada para guarda a posição onde os
          valores serão inseridos no novo vetor. */
        int pos = 0;

        /* Enquanto o inicio não chegar até o meio do vetor, ou o meio do vetor
          não chegar até seu fim, compara os valores entre o inicio e o meio,
          verificando em qual ordem vai guarda-los ordenado.*/
        while(i < meio && m < fim) {
            /* Se o vetor[i] for menor que o vetor[m], então guarda o valor do
              vetor[i] pois este é menor. */
            if(vetor[i] <= vetor[m]) {
              novoVetor[pos] = vetor[i];
              pos = pos + 1;
              i = i + 1;
            // Senão guarda o valor do vetor[m] pois este é o menor.
            } else {
              novoVetor[pos] = vetor[m];
              pos = pos + 1;
              m = m + 1;
            }
        }

        // Adicionar no vetor os elementos que estão entre o inicio e meio,
        // que ainda não foram adicionados no vetor.
        while(i < meio) {
          novoVetor[pos] = vetor[i];
          pos = pos + 1;
          i = i + 1;
        }

        // Adicionar no vetor os elementos que estão entre o meio e o fim,
        // que ainda não foram adicionados no vetor.
        while(m < fim) {
          novoVetor[pos] = vetor[m];
          pos = pos + 1;
          m = m + 1;
        }

        // Coloca no vetor os valores já ordenados.
        for(pos = 0, i = inicio; i < fim; i++, pos++) {
          vetor[i] = novoVetor[pos];
        }
        return vetor;
    }    
    
    
    public int [] radixSort(int [] arr){
        
        if (arr.length == 0)
            return null;

        int[][] np = new int[arr.length][2];
        int[] q = new int[0x100];
        int i, j, k, l, f = 0;

        for (k = 0; k < 4; k++) {
            for (i = 0; i < (np.length - 1); i++)
                    np[i][1] = i + 1;
            np[i][1] = -1;

            for (i = 0; i < q.length; i++)
                    q[i] = -1;
            for (f = i = 0; i < arr.length; i++) {
                    j = ((0xFF << (k << 3)) & arr[i]) >> (k << 3);
                    if (q[j] == -1)
                            l = q[j] = f;

                    else {
                            l = q[j];
                            while (np[l][1] != -1)
                                    l = np[l][1];
                            np[l][1] = f;
                            l = np[l][1];
                    }

                    f = np[f][1];
                    np[l][0] = arr[i];
                    np[l][1] = -1;
            }
            for (l = q[i = j = 0]; i < 0x100; i++)
                    for (l = q[i]; l != -1; l = np[l][1])
                            arr[j++] = np[l][0];
        }
        return arr;
    }
    
    
    public static void main(String[] args) {
        
        TesteOrd ord = new TesteOrd();
        int [] vetor = {5,1,6,8,3,10};
        int [] bubble = ord.bubbleSort(vetor);
        int [] merge = ord.mergeSort(vetor);
        int [] radix = ord.radixSort(vetor);
        
        System.out.println("Bubble");
        for (int i = 0; i < bubble.length; i++){
            System.out.print(bubble[i] +" ");
        }
        System.out.println("");
        System.out.println("Merge");
        for (int i = 0; i < merge.length; i++){
            System.out.print(merge[i] +" ");
        }
        System.out.println("");
        System.out.println("Radix");
        for (int i = 0; i < radix.length; i++){
            System.out.print(radix[i] +" ");
        }
        System.out.println("");
        
        
        String [] aux = {"10","9","8","7","6","5","4","3"};
        int [] nums = new int[aux.length];
        for (int i = 0; i < aux.length; i++){
            nums[i] = Integer.parseInt(aux[i]);
        }
        nums = ord.bubbleSort(nums);
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
        
        
    }
    
    
}
