package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ReportGenerator {
	private File reportFile;

	public ReportGenerator(String path) {
		reportFile = new File(path);
	}

	public void generateReport(ArrayList<ArrayList<Integer>> cycleList, String sysName){
		try{
			if (reportFile.createNewFile()){
				FileWriter writer = new FileWriter(reportFile);
				StringBuilder line = new StringBuilder();
				line.append(new StringBuilder("Ciclos de dependencias para el sistema ").append(sysName));
				line.append(" ");
				line.append("\n");
				line.append("- ");
				for (ArrayList<Integer> cycle:cycleList) {
					for(Integer node:cycle){
						line.append(node.toString());
						line.append(" ");
					}
					line.append("\n");
				}

				writer.write(String.valueOf(line));
				writer.close();
			}
		} catch (IOException e){
			System.out.println("Error abriendo el archivo.");
		}
	}
}

//for (int i = 0;i<KeySetArrayPosElim.length;i++){
//		ciclos = ciclos + "El ciclo de depencias " + KeySetArrayPosElim[i] + " esta compuesto por: ";
//		for (int j = 0; j < listaCiclos.get(KeySetArrayPosElim[i]).size(); j++){
//		System.out.println(ciclos);
//		ciclos = ciclos + " " + InvReferencia.get(listaCiclos.get(KeySetArrayPosElim[i]).get(j)) + " ";
//		}
//		ciclos = ciclos + " \\r\\n";
//		}