/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storalgo;

/**
 *
 * @author خالد
 */
public class StorAlgo {

     
     final static int inf = 999999999;
     public static int d[][]={ {0,3,10} ,{7,0,1},{2,inf,0} };
     public static int d2[][]={ {0,90,100,70} ,{40,0,5,10},{7,inf,0,4},{20,10,7,0} };
     public static int p[][]={ {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0} };
     
     
     public static void floyd(){
         
         for(int i=0;i<d.length;i++){
          for(int j=0;j<d.length;j++){
              for(int k=0;k<d.length;k++){
                  if(i == k && i== j){
                      for(int row=0;row<d.length;row++){
                          if(row != i){
                              for(int col=0;col<d.length;col++){
                                  if(col != j){
                                      if(d[row][col] != 0){
                                       d[row][col]=Math.min(d[row][col],d[row][k]+d[k][col] );  
                                      }
                                       
                                  }
                              }
                          }
                      }
                  }
                  
              }
           }    
         }
     }
          
      public static void modifyfloyd(){
         
         for(int i=0;i<d2.length;i++){
          for(int j=0;j<d2.length;j++){
              for(int k=0;k<d2.length;k++){
                  if(i == k && i== j){
                      for(int row=0;row<d2.length;row++){
                          if(row != i){
                              for(int col=0;col<d2.length;col++){
                                  if(col != j){
                                      if(d2[row][col] != 0){
                                         int temp=d2[row][col];
                                       d2[row][col]=Math.min(d2[row][col],d2[row][k]+d2[k][col] );
                                       if(temp != d2[row][col]){
                                        p[row][col]=k;    
                                       }
                                       
                                      }
                                       
                                  }
                              }
                          }
                      }
                  }
                  
              }
           }    
         }
     }
      public static void printModifyfloyd(){
           System.out.println(" path  shorted path weight");
                for(int i=0;i<d2.length;i++){
                  for(int j=0;j<d2.length;j++){
                      String str,sp;
                      if(p[i][j]==0){
                          str="";
                          sp="      ";
                      }else{
                        str=p[i][j]+"-> ";   
                        sp="  ";
                      }
                      
                      System.out.print("("+i+","+j+") | "+i+" -> "+str+j+sp);
                      System.out.println("| "+d2[i][j]);
                  }
              }
      }
            public static void printfloyd(){
                System.out.println(" path   weight");
                for(int i=0;i<d.length;i++){
                  for(int j=0;j<d.length;j++){
                      System.out.println(i+" -> "+j+" | "+d[i][j]);
                  }
              }
            }

    public static void main(String[] args) {
           System.out.println("*************** Floyd **************");
           floyd();
           printfloyd();
              
              System.out.println("*************** Modify floyd **************");
              modifyfloyd();
              printModifyfloyd();
    }
    
}
