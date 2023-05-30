import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MegaSena {
    
    private static List<Integer> gerarListaSorteios(int quantidadeSorteios) {
        List<Integer> listaSorteios = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < quantidadeSorteios; i++) {
            int numeroSorteado = random.nextInt(60) + 1;
            listaSorteios.add(numeroSorteado);
        }

        return listaSorteios;
    }

    private static int encontrarSequencia(List<Integer> lista, int[] sequencia) {
        int quantidadeSequencia = 0;
        int sequenciaSize = sequencia.length;

        for (int i = 0; i <= lista.size() - sequenciaSize; i++) {
            boolean encontrouSequencia = true;
            for (int j = 0; j < sequenciaSize; j++) {
                if (lista.get(i + j) != sequencia[j]) {
                    encontrouSequencia = false;
                    break;
                }
            }
            if (encontrouSequencia) {
                quantidadeSequencia++;
                System.out.print("Sequência encontrada na posição " + i + ": ");
                for (int k = 0; k < sequenciaSize; k++) {
                    System.out.print(lista.get(i + k) + " ");
                }
                System.out.println();
            }
        }

        return quantidadeSequencia;
    }

    private static List<Integer> inverterLista(List<Integer> lista) {
        List<Integer> listaInvertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            listaInvertida.add(lista.get(i));
        }
        return listaInvertida;
    }


    

    public static void main(String[] args) {
        int[] numerosSorteados = {1, 15, 16, 25, 32, 36};
        int totalSorteios = 51063860;

        List<Integer> listaSorteios = gerarListaSorteios(totalSorteios);
        int quantidadeSequenciaDireta = encontrarSequencia(listaSorteios, numerosSorteados);
        int quantidadeSequenciaInversa = encontrarSequencia(inverterLista(listaSorteios), numerosSorteados);

        System.out.println("Sequência [1, 15, 16, 25, 32, 36] em ordem direta:");
        if (quantidadeSequenciaDireta > 0) {
            System.out.println("Encontrada em " + quantidadeSequenciaDireta + " posição(ões).");
        } else {
            System.out.println("Não encontrada.");
        }

        System.out.println("Sequência [1, 15, 16, 25, 32, 36] em ordem inversa:");
        if (quantidadeSequenciaInversa > 0) {
            System.out.println("Encontrada em " + quantidadeSequenciaInversa + " posição(ões).");
        } else {
            System.out.println("Não encontrada.");
        }
    }
}
