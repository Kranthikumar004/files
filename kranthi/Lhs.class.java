����   = D  demo/Lhs  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this 
Ldemo/Lhs; main ([Ljava/lang/String;)V  java/util/LinkedHashSet
  	
    java/lang/Integer   valueOf (I)Ljava/lang/Integer;
     add (Ljava/lang/Object;)Z  ABHI   c
  " # $ iterator ()Ljava/util/Iterator; & ( ' java/util/Iterator ) * hasNext ()Z	 , . - java/lang/System / 0 out Ljava/io/PrintStream; & 2 3 4 next ()Ljava/lang/Object;
 6 8 7 java/io/PrintStream 9 : println (Ljava/lang/Object;)V args [Ljava/lang/String; lhs Ljava/util/LinkedHashSet; i Ljava/util/Iterator; StackMapTable 
SourceFile Lhs.java !               /     *� �    
                    	       �     N� Y� L+� � W+4� � W+� W+4� � W+� W+� !M,� % ���� +,� 1 � 5�    
   * 
   	  
     "  ,  3  8  A  M          N ; <    F = >  8  ? @  A    � 8  &  B    C