package be.BiscontiLagneau.Enum;

public enum Specialisation {
	Cardiologie("Cardiologie"),
	Generale("G�n�rale"),
	Pneumologie("Pneumologie"),
	Neurologie("Neurologie"),
	Ophtalmologie("Ophtalmologie"),
	Psychiatre("Psychiatre"),
	Dermatologie("Dermatologie"),
	Gynecologie("Gyn�cologie");
	
	private String spec;
	
	Specialisation(String s){
		this.spec = s;
	}
	
	public String getSpec() {
		return this.spec;
	}
	
	public static Specialisation fromString(String text) {
		for (Specialisation s : Specialisation.values()) {
            if (s.spec.equals(text)) {
                return s;
            }
        }
        return null;
	}
}
