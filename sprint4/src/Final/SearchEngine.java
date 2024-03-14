package Final;

import java.io.*;
import java.util.*;

class DataPair<K, V> {
    private final K key;
    private V value;

    public DataPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}


public class SearchEngine {
    public static Map<String, List<DataPair<Integer, Integer>>> buildIndex(BufferedReader br, int n) throws IOException {
        Map<String, List<DataPair<Integer, Integer>>> index = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String document = br.readLine();
            String[] words = document.split(" ");

            for (String word : words) {
                if (!index.containsKey(word)) {
                    index.put(word, new ArrayList<>());
                }

                List<DataPair<Integer, Integer>> docsWithWord = index.get(word);
                boolean exist = false;
                for (DataPair<Integer, Integer> dataPair : docsWithWord) {
                    if (dataPair.getKey() == i) {
                        dataPair.setValue(dataPair.getValue() + 1);
                        exist = true;
                        break;
                    }
                }

                if (!exist) {
                    docsWithWord.add(new DataPair<>(i, 1));
                }
            }
        }

        return index;


    }

    public static int[] calculateScores(String query, Map<String, List<DataPair<Integer, Integer>>> index, int docIdx) {
        int[] scores = new int[docIdx];
        String[] queryWords = query.split(" ");
        Set<String> stringHashSet = new HashSet<>(Arrays.asList(queryWords));

        for (String word : stringHashSet) {
            List<DataPair<Integer, Integer>> dataPairList = index.get(word);
            if (dataPairList != null) {
                for (DataPair<Integer, Integer> dataPair : dataPairList) {
                    int count = dataPair.getValue();
                    int doc = dataPair.getKey();
                    scores[doc] += count;
                }
            }
        }

        return scores;
    }

    public static List<Integer> getRelevance(int[] scores) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < scores.length; i++) {
//            if (scores[i] > 0) {
//                list.add(i);
//            }
//        }
//        list.sort((a, b) -> {
//            if (scores[a] != scores[b]) {
//                return Integer.compare(scores[b], scores[a]);
//            } else {
//                return Integer.compare(a, b);
//            }
//        });
//        return list.subList(0, Math.min(5, list.size()));
        List<Integer> list = new ArrayList<>();

        int[] copyScores = Arrays.copyOf(scores, scores.length);

        for (int count = 0; count < 5; count++) {
            int maxIndex = 0;
            int maxScore = -1;

            for (int i = 0; i < copyScores.length; i++) {
                if (copyScores[i] > maxScore) {
                    maxIndex = i;
                    maxScore = copyScores[i];
                }
            }

            if (copyScores[maxIndex] != 0) {
                list.add(maxIndex);
            }

            copyScores[maxIndex] = 0;
        }

        return list;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        Map<String, List<DataPair<Integer, Integer>>> index = buildIndex(reader, n);

        int m = Integer.parseInt(reader.readLine());


        for (int i = 0; i < m; i++) {
            String query = reader.readLine();
            int[] scores = calculateScores(query, index, n);
            List<Integer> list = getRelevance(scores);
            for (int id : list) {
                writer.write((id + 1) + " ");
            }
            writer.newLine();
        }


        writer.flush();
        writer.close();
        reader.close();
    }
}