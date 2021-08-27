package br.com.alura.loja.modelo;

public enum TipoEndereco implements EnumValor {
	RESIDENCIAL {

		@Override
		public String getTipo() {
			// TODO Auto-generated method stub
			return "R";
		}

	},
	COMERCIAL {

		@Override
		public String getTipo() {
			// TODO Auto-generated method stub
			return "C";
		}
	},
	FINANCEIRO {

		@Override
		public String getTipo() {
			// TODO Auto-generated method stub
			return "F";
		}
	},
	INSTALACAO {

		@Override
		public String getTipo() {
			// TODO Auto-generated method stub
			return "I";
		}

	};

}

interface EnumValor {
	String getTipo();
}
