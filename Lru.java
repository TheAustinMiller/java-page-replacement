public class Lru {

    public static int isNotEmpty(int[]arr, int n, int key) {
        for (int i = 0; i < n; i++) {
            if(arr[i]==key) {
                return i;
            }
        }
        return -1;
    }

    public void lru(int frames, int len, int[] refString, boolean f) {
        int i = 0;

        int j = 0;
        int frame[] = new int[frames];
        int distance[] = new int[frames];
        for(i = 0; i < frames; i++) {
            frame[i] = -1;
        }

        for (i = 0; i < frames; i++) {
            distance[i] = 0;
        }


        int meme = 0;
        int pFaults = 0;

        for (i = 0; i < len; i++) {
            meme = isNotEmpty(frame, frames, refString[i]);
            if(meme != -1) {
                for(j = 0;j < frames; j++) {
                    distance[j]++;
                }
                distance[meme]=0;
            }
            else {
                meme = isEmpty(frame, frames);
                if (meme != -1) {
                    frame[meme] = refString[i];
                    pFaults++;
                    for(j = 0; j < frames; j++) {
                        distance[j]++;
                    }
                    distance[meme]=0;
                }
                else {
                    meme = distance(distance, frames);
                    frame[meme] = refString[i];
                    pFaults++;
                    for(j = 0; j < frames; j++) {
                        distance[j]++;
                    }
                    distance[meme]=0;
                }
            }

        }

        if (f) {
            System.out.println("LRU had "+pFaults+" page faults");
        }


    }

    public static int distance(int []arr, int n) {
        int k = 0;
        for(int i = 1; i < n; i++) {
            if(arr[k] < arr[i])
                k = i;
        }
        return k;
    }

    public static int isEmpty(int []arr, int len){
        int i = 0;
        for(i = 0; i < len; i++) {
            if (arr[i] == -1) {
                return i;
            }
        }
        return -1;
    }


}
