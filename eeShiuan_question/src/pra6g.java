
public class pra6g {
    
    public static void main(String[] args) {
        int card[] = new int [52];
        for(int i=0; i<52; i++) {	//�@�Ƽ��J�P�P��
            card[i] = i;
        }
        
        System.out.println("��P��");
        String s = "print()";
        
        int get[] = new int [5];
        for(int n=0; n<get.length; n++) {
            get[n] = shuffle(card, card.length);
        }
        
        System.out.println("�Ү��쪺�P��");
        System.out.println(get);
        
    }
    public static int shuffle(int a[], int count) {  //�~�P��P   //�ǭ�
        int r = 0;
        for(int i=0; i<count; i++) {
            r = (int)(Math.random()*count);
            int temp = a[r];
            a[r] = a[i];
            a[i] = temp;
        }
        return a[r];
    }
    public String toString() {  //�C�L
        String str[]= {"�®�","����","���","�R��"};
        String s = "";	
        for(int i=0; i<52; i++) {
            s += str[i % 13]+(i%4+1)+"\n";
        }
        System.out.print("");
        return s;
    }
    
}
