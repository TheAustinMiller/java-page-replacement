public class Fifo {
    public void fifo(int frames, int len, int[] refString, boolean f) {
        int i = 0;
        int frame[] = new int[frames];
        for(i = 0; i < frames; i++) {
            frame[i] = -1;
        }
        int meme = 0;
        int index = 0;
        int pf=0;
        for(i = 0; i < len; i++) {
            if (isNotEmpty(frame, frames, refString[i]) != -1) {
            }
            else {
                meme = isEmpty(frame, frames);
                if (meme!=-1) {
                    frame[meme] = refString[i];
                    index = (index+1)%frames;
                    pf++;
                }
                else {
                    frame[index] = refString[i];
                    index = (index+1)%frames;
                    pf++;
                }
            }

        }

        if (f) {
            System.out.println("FIFO had " + pf + " page faults");
        }
    }

    public static int isEmpty(int []arr, int n) {
        int i = 0;
        for (i = 0; i < n; i++)
            if(arr[i] == -1) {
                return i;
            }
        return -1;
    }

    public static int isNotEmpty(int []arr, int n, int key) {
        for (int i = 0; i < n; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

}
