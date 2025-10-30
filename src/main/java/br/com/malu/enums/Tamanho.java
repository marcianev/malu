package br.com.malu.enums;

public enum Tamanho {
	PP("PP"),
	U("U"),
	P("P"),
	M("M"),
	G("G"),
	GG("GG"),
	T_36("36"),
	T_38("38"),
	T_40("40"),
	T_42("42"),
	T_44("44"),
	T_46("46"),
	T_48("48"),
	T_50("50"),
	T_52("52");
	
	  private final String label;

	    private Tamanho(String label) {
	        this.label = label;
	    }

	    public String getLabel() {
	        return label;
	    }
	    
	    public static Tamanho fromLabel(String label) {
	        for (Tamanho t : Tamanho.values()) {
	            if (t.label.equals(label)) {
	                return t;
	            }
	        }
	        throw new IllegalArgumentException("Tamanho inválido: " + label);
	    }
}
