import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
public class Frame  {

	private JFrame frmJavaMangeBatch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	private final ButtonGroup buttonGroup_5 = new ButtonGroup();
	private final ButtonGroup buttonGroup_6 = new ButtonGroup();
	private final ButtonGroup buttonGroup_7 = new ButtonGroup();
	 Path currentRelativePath = Paths.get("");
	private String s = currentRelativePath.toAbsolutePath().toString();
    private List <String> fileList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frmJavaMangeBatch.setVisible(true);
					Find find = new Find();
					find.MigrateFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJavaMangeBatch = new JFrame();
		frmJavaMangeBatch.setTitle("Java Manage Batch File");
		frmJavaMangeBatch.setBounds(100, 100, 450, 360);
		frmJavaMangeBatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJavaMangeBatch.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AIS Move File to Folder");
		lblNewLabel.setBounds(99, 0, 335, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		frmJavaMangeBatch.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sampling Seal 1");
		lblNewLabel_1.setBounds(21, 47, 122, 14);
		frmJavaMangeBatch.getContentPane().add(lblNewLabel_1);
		
		JRadioButton Seal1TKS = new JRadioButton("TKS");
		buttonGroup.add(Seal1TKS);
		Seal1TKS.setBounds(178, 43, 70, 23);
		frmJavaMangeBatch.getContentPane().add(Seal1TKS);
		
		JRadioButton Sea1DXP = new JRadioButton("DXP");
		buttonGroup.add(Sea1DXP);
		Sea1DXP.setBounds(263, 43, 109, 23);
		frmJavaMangeBatch.getContentPane().add(Sea1DXP);
		
		JLabel lblSamplingSeal = new JLabel("Sampling Seal 2");
		lblSamplingSeal.setBounds(21, 72, 122, 14);
		frmJavaMangeBatch.getContentPane().add(lblSamplingSeal);
		
		JRadioButton Seal2TKS = new JRadioButton("TKS");
		buttonGroup_1.add(Seal2TKS);
		Seal2TKS.setBounds(178, 68, 70, 23);
		frmJavaMangeBatch.getContentPane().add(Seal2TKS);
		
		JRadioButton Seal2DXP = new JRadioButton("DXP");
		buttonGroup_1.add(Seal2DXP);
		Seal2DXP.setBounds(263, 68, 109, 23);
		frmJavaMangeBatch.getContentPane().add(Seal2DXP);
		
		JLabel lblSamplingWrap = new JLabel("Sampling Wrapping 1");
		lblSamplingWrap.setBounds(21, 97, 122, 14);
		frmJavaMangeBatch.getContentPane().add(lblSamplingWrap);
		
		JRadioButton Wrap1TKS = new JRadioButton("TKS");
		buttonGroup_2.add(Wrap1TKS);
		Wrap1TKS.setBounds(178, 93, 70, 23);
		frmJavaMangeBatch.getContentPane().add(Wrap1TKS);
		
		JRadioButton Wrap1DXP = new JRadioButton("DXP");
		buttonGroup_2.add(Wrap1DXP);
		Wrap1DXP.setBounds(263, 93, 109, 23);
		frmJavaMangeBatch.getContentPane().add(Wrap1DXP);
		
		JLabel lblSamplingWrapping = new JLabel("Sampling Wrapping 2");
		lblSamplingWrapping.setBounds(21, 122, 122, 14);
		frmJavaMangeBatch.getContentPane().add(lblSamplingWrapping);
		
		JRadioButton Wrap2TKS = new JRadioButton("TKS");
		buttonGroup_3.add(Wrap2TKS);
		Wrap2TKS.setBounds(178, 118, 70, 23);
		frmJavaMangeBatch.getContentPane().add(Wrap2TKS);
		
		JRadioButton Wrap2DXP = new JRadioButton("DXP");
		buttonGroup_3.add(Wrap2DXP);
		Wrap2DXP.setBounds(263, 118, 109, 23);
		frmJavaMangeBatch.getContentPane().add(Wrap2DXP);
		
		JLabel lblSamplingEnv = new JLabel("Sampling ENV");
		lblSamplingEnv.setBounds(21, 147, 122, 14);
		frmJavaMangeBatch.getContentPane().add(lblSamplingEnv);
		
		JRadioButton EnvTKS = new JRadioButton("TKS");
		buttonGroup_4.add(EnvTKS);
		EnvTKS.setBounds(178, 143, 70, 23);
		frmJavaMangeBatch.getContentPane().add(EnvTKS);
		
		JRadioButton EnvDXP = new JRadioButton("DXP");
		buttonGroup_4.add(EnvDXP);
		EnvDXP.setBounds(263, 143, 109, 23);
		frmJavaMangeBatch.getContentPane().add(EnvDXP);
		
		JLabel lblQcSeal = new JLabel("QC Seal");
		lblQcSeal.setBounds(21, 172, 122, 14);
		frmJavaMangeBatch.getContentPane().add(lblQcSeal);
		
		JRadioButton QCSTKS = new JRadioButton("TKS");
		buttonGroup_5.add(QCSTKS);
		QCSTKS.setBounds(178, 168, 70, 23);
		frmJavaMangeBatch.getContentPane().add(QCSTKS);
		
		JRadioButton QCSDXP = new JRadioButton("DXP");
		buttonGroup_5.add(QCSDXP);
		QCSDXP.setBounds(263, 168, 109, 23);
		frmJavaMangeBatch.getContentPane().add(QCSDXP);
		
		JLabel lblQcWrapping = new JLabel("QC Wrapping");
		lblQcWrapping.setBounds(21, 197, 122, 14);
		frmJavaMangeBatch.getContentPane().add(lblQcWrapping);
		
		JRadioButton QCWTKS = new JRadioButton("TKS");
		buttonGroup_6.add(QCWTKS);
		QCWTKS.setBounds(178, 193, 70, 23);
		frmJavaMangeBatch.getContentPane().add(QCWTKS);
		
		JRadioButton QCWDXP = new JRadioButton("DXP");
		buttonGroup_6.add(QCWDXP);
		QCWDXP.setBounds(263, 193, 109, 23);
		frmJavaMangeBatch.getContentPane().add(QCWDXP);
		
		JLabel lblQcWrapping_1 = new JLabel("QC ENV");
		lblQcWrapping_1.setBounds(21, 223, 122, 14);
		frmJavaMangeBatch.getContentPane().add(lblQcWrapping_1);
		
		JRadioButton QCETKS = new JRadioButton("TKS");
		buttonGroup_7.add(QCETKS);
		QCETKS.setBounds(178, 219, 70, 23);
		frmJavaMangeBatch.getContentPane().add(QCETKS);
		
		JRadioButton QCEDXP = new JRadioButton("DXP");
		buttonGroup_7.add(QCEDXP);
		QCEDXP.setBounds(263, 219, 109, 23);
		frmJavaMangeBatch.getContentPane().add(QCEDXP);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		     	   new File(s+"/EXAM_TKS").mkdirs();
		     	   new File(s+"/EXAM_DXP").mkdirs();
		     	   int checkSelected = 0;
		     	  int randomInt = (int)(3.0 * Math.random());
		     	 int SummaryReport = 0;
		     	  


	                
		     	  try {
					FileWriter myWriterRep = new FileWriter(s+"\\Summary_Report.txt", true);
					myWriterRep.write("After Zip ==================== \n");
		     	if(SelectedAll()) {
		     	  if(Seal1TKS.isSelected()) {
						Files.move(new File(s+"\\Sampling_Seal_1").toPath(), new File(s+"\\EXAM_TKS\\Sampling_Seal_1").toPath(), StandardCopyOption.REPLACE_EXISTING);
			     		 File folder = new File(s+"\\EXAM_TKS\\Sampling_Seal_1");
				     		File[] listOfFiles = folder.listFiles();
				     		for (int i = 0; i < listOfFiles.length; i++) {
				     		  if (listOfFiles[i].isFile()&&i == randomInt) {
				     		  //  System.out.println("File " + listOfFiles[i].getName());
				     		   File file = new File(s+"\\EXAM_TKS\\Sampling_Seal_1\\"+listOfFiles[i].getName());
				     		   File file2 = new File(s+"\\EXAM_TKS\\Sampling_Seal_1\\100%_"+listOfFiles[i].getName());
				     		   file.renameTo(file2);
				     		  }
				     		}
			                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_TKS\\Sampling_Seal_1"))) {
				                myWriterRep.write("Folder : EXAM_TKS : Sampling_Seal_1 \n");
				                	List<String> result = walk.map(x -> x.toString())
				                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
				                	int rep = 0;
				                	while(rep < result.size()) {
				                		myWriterRep.write(result.get(rep)+" \n");
				                	rep++;
				                	}
				                	myWriterRep.write("Total >>>"+result.size()+" \n");
				                	SummaryReport += result.size();
				                } catch (IOException e) {
				                	e.printStackTrace();
				                }
		     	  }else if (Sea1DXP.isSelected()){
		     		 Files.move(new File(s+"\\Sampling_Seal_1").toPath(), new File(s+"\\EXAM_DXP\\Sampling_Seal_1").toPath(), StandardCopyOption.REPLACE_EXISTING);
		     		
		     		 File folder = new File(s+"\\EXAM_DXP\\Sampling_Seal_1");
			     		File[] listOfFiles = folder.listFiles();
			     		for (int i = 0; i < listOfFiles.length; i++) {
			     		  if (listOfFiles[i].isFile()&&i == randomInt) {
			     		 //   System.out.println("File " + listOfFiles[i].getName());
			     		   File file = new File(s+"\\EXAM_DXP\\Sampling_Seal_1\\"+listOfFiles[i].getName());
			     		   File file2 = new File(s+"\\EXAM_DXP\\Sampling_Seal_1\\100%_"+listOfFiles[i].getName());
			     		   file.renameTo(file2);
			     		  }
			     		}
		     		
		                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_DXP\\Sampling_Seal_1"))) {
			                myWriterRep.write("Folder : EXAM_DXP : Sampling_Seal_1 \n");
			                	List<String> result = walk.map(x -> x.toString())
			                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
			                	int rep = 0;
			                	while(rep < result.size()) {
			                		myWriterRep.write(result.get(rep)+" \n");
			                	rep++;
			                	}
			                	myWriterRep.write("Total >>>"+result.size()+" \n");
			                	SummaryReport += result.size();
			                } catch (IOException e) {
			                	e.printStackTrace();
			                }
		     	  }
		     	  
		     	  if(Seal2TKS.isSelected()) {
						Files.move(new File(s+"\\Sampling_Seal_2").toPath(), new File(s+"\\EXAM_TKS\\Sampling_Seal_2").toPath(), StandardCopyOption.REPLACE_EXISTING);
			     		
						File folder = new File(s+"\\EXAM_TKS\\\\Sampling_Seal_2");
				     		File[] listOfFiles = folder.listFiles();
				     		for (int i = 0; i < listOfFiles.length; i++) {
				     		  if (listOfFiles[i].isFile()&&i == randomInt) {
				     		   // System.out.println("File " + listOfFiles[i].getName());
				     		   File file = new File(s+"\\EXAM_TKS\\\\Sampling_Seal_2\\"+listOfFiles[i].getName());
				     		   File file2 = new File(s+"\\EXAM_TKS\\\\Sampling_Seal_2\\100%_"+listOfFiles[i].getName());
				     		   file.renameTo(file2);
				     		  }
				     		}
				     		
			                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_TKS\\Sampling_Seal_2"))) {
				                myWriterRep.write("Folder : EXAM_TKS : Sampling_Seal_2 \n");
				                	List<String> result = walk.map(x -> x.toString())
				                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
				                	int rep = 0;
				                	while(rep < result.size()) {
				                		myWriterRep.write(result.get(rep)+" \n");
				                	rep++;
				                	}
				                	myWriterRep.write("Total >>>"+result.size()+" \n");
				                	SummaryReport += result.size();
				                } catch (IOException e) {
				                	e.printStackTrace();
				                }
			                
		     	  }else if (Seal2DXP.isSelected()){
		     		 Files.move(new File(s+"\\Sampling_Seal_2").toPath(), new File(s+"\\EXAM_DXP\\Sampling_Seal_2").toPath(), StandardCopyOption.REPLACE_EXISTING);
		     		
		     		 File folder = new File(s+"\\EXAM_DXP\\Sampling_Seal_2");
			     		File[] listOfFiles = folder.listFiles();
			     		for (int i = 0; i < listOfFiles.length; i++) {
			     		  if (listOfFiles[i].isFile()&&i == randomInt) {
			     		 //   System.out.println("File " + listOfFiles[i].getName());
			     		   File file = new File(s+"\\EXAM_DXP\\Sampling_Seal_2\\"+listOfFiles[i].getName());
			     		   File file2 = new File(s+"\\EXAM_DXP\\Sampling_Seal_2\\100%_"+listOfFiles[i].getName());
			     		   file.renameTo(file2);
			     		  }
			     		}
		                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_DXP\\Sampling_Seal_2"))) {
			                myWriterRep.write("Folder : EXAM_DXP : Sampling_Seal_2 \n");
			                	List<String> result = walk.map(x -> x.toString())
			                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
			                	int rep = 0;
			                	while(rep < result.size()) {
			                		myWriterRep.write(result.get(rep)+" \n");
			                	rep++;
			                	}
			                	myWriterRep.write("Total >>>"+result.size()+" \n");
			                	SummaryReport += result.size();
			                } catch (IOException e) {
			                	e.printStackTrace();
			                }
		     	  }
		     	  
		     	  if(Wrap1TKS.isSelected()) {
						Files.move(new File(s+"\\Sampling_Wrapping_1").toPath(), new File(s+"\\EXAM_TKS\\Sampling_Wrapping_1").toPath(), StandardCopyOption.REPLACE_EXISTING);
						
			     		 File folder = new File(s+"\\EXAM_TKS\\Sampling_Wrapping_1");
				     		File[] listOfFiles = folder.listFiles();
				     		for (int i = 0; i < listOfFiles.length; i++) {
				     		  if (listOfFiles[i].isFile()&&i == randomInt) {
				     		//    System.out.println("File " + listOfFiles[i].getName());
				     		   File file = new File(s+"\\EXAM_TKS\\Sampling_Wrapping_1\\"+listOfFiles[i].getName());
				     		   File file2 = new File(s+"\\EXAM_TKS\\Sampling_Wrapping_1\\100%_"+listOfFiles[i].getName());
				     		   file.renameTo(file2);
				     		  }
				     		}
				     		
			                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_TKS\\Sampling_Wrapping_1"))) {
				                myWriterRep.write("Folder : EXAM_TKS : Sampling_Wrapping_1 \n");
				                	List<String> result = walk.map(x -> x.toString())
				                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
				                	int rep = 0;
				                	while(rep < result.size()) {
				                		myWriterRep.write(result.get(rep)+" \n");
				                	rep++;
				                	}
				                	myWriterRep.write("Total >>>"+result.size()+" \n");
				                	SummaryReport += result.size();
				                } catch (IOException e) {
				                	e.printStackTrace();
				                }
				     		
		     	  }else if (Wrap1DXP.isSelected()){
		     		 Files.move(new File(s+"\\Sampling_Wrapping_1").toPath(), new File(s+"\\EXAM_DXP\\Sampling_Wrapping_1").toPath(), StandardCopyOption.REPLACE_EXISTING);
		     		 		
		     		 File folder = new File(s+"\\EXAM_DXP\\Sampling_Wrapping_1");
			     		File[] listOfFiles = folder.listFiles();
			     		for (int i = 0; i < listOfFiles.length; i++) {
			     		  if (listOfFiles[i].isFile()&&i == randomInt) {
			     		//    System.out.println("File " + listOfFiles[i].getName());
			     		   File file = new File(s+"\\EXAM_DXP\\Sampling_Wrapping_1\\"+listOfFiles[i].getName());
			     		   File file2 = new File(s+"\\EXAM_DXP\\Sampling_Wrapping_1\\100%_"+listOfFiles[i].getName());
			     		   file.renameTo(file2);
			     		  }
			     		}
			     		
		                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_DXP\\Sampling_Wrapping_1"))) {
			                myWriterRep.write("Folder : EXAM_DXP : Sampling_Wrapping_1 \n");
			                	List<String> result = walk.map(x -> x.toString())
			                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
			                	int rep = 0;
			                	while(rep < result.size()) {
			                		myWriterRep.write(result.get(rep)+" \n");
			                	rep++;
			                	}
			                	myWriterRep.write("Total >>>"+result.size()+" \n");
			                	SummaryReport += result.size();
			                } catch (IOException e) {
			                	e.printStackTrace();
			                }
		     	  }
		     	  
		     	  if(Wrap2TKS.isSelected()) {
						Files.move(new File(s+"\\Sampling_Wrapping_2").toPath(), new File(s+"\\EXAM_TKS\\Sampling_Wrapping_2").toPath(), StandardCopyOption.REPLACE_EXISTING);
						
			     		 File folder = new File(s+"\\EXAM_TKS\\Sampling_Wrapping_2");
				     		File[] listOfFiles = folder.listFiles();
				     		for (int i = 0; i < listOfFiles.length; i++) {
				     		  if (listOfFiles[i].isFile()&&i == randomInt) {
				     		  //  System.out.println("File " + listOfFiles[i].getName());
				     		   File file = new File(s+"\\EXAM_TKS\\Sampling_Wrapping_2\\"+listOfFiles[i].getName());
				     		   File file2 = new File(s+"\\EXAM_TKS\\Sampling_Wrapping_2\\100%_"+listOfFiles[i].getName());
				     		   file.renameTo(file2);
				     		  }
				     		}
				     		
			                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_TKS\\Sampling_Wrapping_2"))) {
				                myWriterRep.write("Folder : EXAM_TKS : Sampling_Wrapping_2 \n");
				                	List<String> result = walk.map(x -> x.toString())
				                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
				                	int rep = 0;
				                	while(rep < result.size()) {
				                		myWriterRep.write(result.get(rep)+" \n");
				                	rep++;
				                	}
				                	myWriterRep.write("Total >>>"+result.size()+" \n");
				                	SummaryReport += result.size();
				                } catch (IOException e) {
				                	e.printStackTrace();
				                }
		     	  }else if (Wrap2DXP.isSelected()){
		     		 Files.move(new File(s+"\\Sampling_Wrapping_2").toPath(), new File(s+"\\EXAM_DXP\\Sampling_Wrapping_2").toPath(), StandardCopyOption.REPLACE_EXISTING);
		     		 		
		     		 File folder = new File(s+"\\EXAM_DXP\\Sampling_Wrapping_2");
			     		File[] listOfFiles = folder.listFiles();
			     		for (int i = 0; i < listOfFiles.length; i++) {
			     		  if (listOfFiles[i].isFile()&&i == randomInt) {
			     		 //   System.out.println("File " + listOfFiles[i].getName());
			     		   File file = new File(s+"\\EXAM_DXP\\Sampling_Wrapping_2\\"+listOfFiles[i].getName());
			     		   File file2 = new File(s+"\\EXAM_DXP\\Sampling_Wrapping_2\\100%_"+listOfFiles[i].getName());
			     		   file.renameTo(file2);
			     		  }
			     		}
			     		
		                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_DXP\\Sampling_Wrapping_2"))) {
			                myWriterRep.write("Folder : EXAM_DXP : Sampling_Wrapping_2 \n");
			                	List<String> result = walk.map(x -> x.toString())
			                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
			                	int rep = 0;
			                	while(rep < result.size()) {
			                		myWriterRep.write(result.get(rep)+" \n");
			                	rep++;
			                	}
			                	myWriterRep.write("Total >>>"+result.size()+" \n");
			                	SummaryReport += result.size();
			                } catch (IOException e) {
			                	e.printStackTrace();
			                }
		     	  }
		     	  
		     	  if(EnvTKS.isSelected()) {
						Files.move(new File(s+"\\Sampling_ENV").toPath(), new File(s+"\\EXAM_TKS\\Sampling_ENV").toPath(), StandardCopyOption.REPLACE_EXISTING);
						
			     		 File folder = new File(s+"\\EXAM_TKS\\Sampling_ENV");
				     		File[] listOfFiles = folder.listFiles();
				     		for (int i = 0; i < listOfFiles.length; i++) {
				     		  if (listOfFiles[i].isFile()&&i == randomInt) {
				     		//    System.out.println("File " + listOfFiles[i].getName());
				     		   File file = new File(s+"\\EXAM_TKS\\Sampling_ENV\\"+listOfFiles[i].getName());
				     		   File file2 = new File(s+"\\EXAM_TKS\\Sampling_ENV\\100%_"+listOfFiles[i].getName());
				     		   file.renameTo(file2);
				     		  }
				     		}
				     		
			                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_TKS\\Sampling_ENV"))) {
				                myWriterRep.write("Folder : EXAM_TKS : Sampling_ENV \n");
				                	List<String> result = walk.map(x -> x.toString())
				                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
				                	int rep = 0;
				                	while(rep < result.size()) {
				                		myWriterRep.write(result.get(rep)+" \n");
				                	rep++;
				                	}
				                	myWriterRep.write("Total >>>"+result.size()+" \n");
				                	SummaryReport += result.size();
				                } catch (IOException e) {
				                	e.printStackTrace();
				                }
				     		
		     	  }else if (EnvDXP.isSelected()){
		     		 Files.move(new File(s+"\\Sampling_ENV").toPath(), new File(s+"\\EXAM_DXP\\Sampling_ENV").toPath(), StandardCopyOption.REPLACE_EXISTING);
		     		 		
		     		 File folder = new File(s+"\\EXAM_DXP\\Sampling_ENV");
			     		File[] listOfFiles = folder.listFiles();
			     		for (int i = 0; i < listOfFiles.length; i++) {
			     		  if (listOfFiles[i].isFile()&&i == randomInt) {
			     		 //   System.out.println("File " + listOfFiles[i].getName());
			     		   File file = new File(s+"\\EXAM_DXP\\Sampling_ENV\\"+listOfFiles[i].getName());
			     		   File file2 = new File(s+"\\EXAM_DXP\\Sampling_ENV\\100%_"+listOfFiles[i].getName());
			     		   file.renameTo(file2);
			     		  }
			     		}
			     		
		                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_DXP\\Sampling_ENV"))) {
			                myWriterRep.write("Folder : EXAM_DXP : Sampling_ENV \n");
			                	List<String> result = walk.map(x -> x.toString())
			                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
			                	int rep = 0;
			                	while(rep < result.size()) {
			                		myWriterRep.write(result.get(rep)+" \n");
			                	rep++;
			                	}
			                	myWriterRep.write("Total >>>"+result.size()+" \n");
			                	SummaryReport += result.size();
			                } catch (IOException e) {
			                	e.printStackTrace();
			                }
		     	  }
		     	  
		     	  
		     	  
		     	  
		     	  if(QCSTKS.isSelected()) {
						Files.move(new File(s+"\\QC_Seal").toPath(), new File(s+"\\EXAM_TKS\\QC_Seal").toPath(), StandardCopyOption.REPLACE_EXISTING);
						
						long size = Files.walk(Paths.get(s+"\\EXAM_TKS\\QC_Seal")).mapToLong( p -> p.toFile().length() ).sum();
						//System.out.println("size "+ size);
						if(size == 0) {
				     		 File folder = new File(s+"\\EXAM_TKS\\Sampling_Seal_1");
					     		File[] listOfFiles = folder.listFiles();
					     		for (int i = 0; i < listOfFiles.length; i++) {
					     		  if (listOfFiles[i].isFile()) {
					     		   // System.out.println("File " + listOfFiles[i].getName());
					     		   if (listOfFiles[i].getName().indexOf("100%")!=0) {
					     		   File file = new File(s+"\\EXAM_TKS\\Sampling_Seal_1\\"+listOfFiles[i].getName());
					     		   File file2 = new File(s+"\\EXAM_TKS\\Sampling_Seal_1\\QC_"+listOfFiles[i].getName());
					     		   file.renameTo(file2);
					     		   break;
					     		   }
					     		  }
					     		}
						}
						
		                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_TKS\\QC_Seal"))) {
			                myWriterRep.write("Folder : EXAM_TKS : QC_Seal \n");
			                	List<String> result = walk.map(x -> x.toString())
			                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
			                	int rep = 0;
			                	while(rep < result.size()) {
			                		myWriterRep.write(result.get(rep)+" \n");
			                	rep++;
			                	}
			                	myWriterRep.write("Total >>>"+result.size()+" \n");
			                	SummaryReport += result.size();
			                } catch (IOException e) {
			                	e.printStackTrace();
			                }
					     		
		     	  }else if (QCSDXP.isSelected()){
		     		 Files.move(new File(s+"\\QC_Seal").toPath(), new File(s+"\\EXAM_DXP\\QC_Seal").toPath(), StandardCopyOption.REPLACE_EXISTING);
						long size = Files.walk(Paths.get(s+"\\EXAM_DXP\\QC_Seal")).mapToLong( p -> p.toFile().length() ).sum();
						//System.out.println("size "+ size);
						if(size == 0) {
				     		 File folder = new File(s+"\\EXAM_DXP\\Sampling_Seal_1");
					     		File[] listOfFiles = folder.listFiles();
					     		for (int i = 0; i < listOfFiles.length; i++) {
					     		  if (listOfFiles[i].isFile()) {
					     		 //   System.out.println("File " + listOfFiles[i].getName());
					     		   if (listOfFiles[i].getName().indexOf("100%")!=0) {
					     		   File file = new File(s+"\\EXAM_DXP\\Sampling_Seal_1\\"+listOfFiles[i].getName());
					     		   File file2 = new File(s+"\\EXAM_DXP\\Sampling_Seal_1\\QC_"+listOfFiles[i].getName());
					     		   file.renameTo(file2);
					     		   break;
					     		   }
					     		  }
					     		}
						}
						
		                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_DXP\\QC_Seal"))) {
			                myWriterRep.write("Folder : EXAM_DXP : QC_Seal \n");
			                	List<String> result = walk.map(x -> x.toString())
			                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
			                	int rep = 0;
			                	while(rep < result.size()) {
			                		myWriterRep.write(result.get(rep)+" \n");
			                	rep++;
			                	}
			                	myWriterRep.write("Total >>>"+result.size()+" \n");
			                	SummaryReport += result.size();
			                } catch (IOException e) {
			                	e.printStackTrace();
			                }
		     	  }
		     	  
		     	  if(QCWTKS.isSelected()) {
						Files.move(new File(s+"\\QC_Wrap").toPath(), new File(s+"\\EXAM_TKS\\QC_Wrap").toPath(), StandardCopyOption.REPLACE_EXISTING);
						long size = Files.walk(Paths.get(s+"\\EXAM_TKS\\QC_Wrap")).mapToLong( p -> p.toFile().length() ).sum();
						//System.out.println("size "+ size);
						if(size == 0) {
				     		 File folder = new File(s+"\\EXAM_TKS\\Sampling_Wrapping_1");
					     		File[] listOfFiles = folder.listFiles();
					     		for (int i = 0; i < listOfFiles.length; i++) {
					     		  if (listOfFiles[i].isFile()) {
					     		  //  System.out.println("File " + listOfFiles[i].getName());
					     		   if (listOfFiles[i].getName().indexOf("100%")!=0) {
					     		   File file = new File(s+"\\EXAM_TKS\\Sampling_Wrapping_1\\"+listOfFiles[i].getName());
					     		   File file2 = new File(s+"\\EXAM_TKS\\Sampling_Wrapping_1\\QC_"+listOfFiles[i].getName());
					     		   file.renameTo(file2);
					     		   break;
					     		   }
					     		  }
					     		}
						}
						
		                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_TKS\\QC_Wrap"))) {
			                myWriterRep.write("Folder : EXAM_TKS : QC_Wrap \n");
			                	List<String> result = walk.map(x -> x.toString())
			                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
			                	int rep = 0;
			                	while(rep < result.size()) {
			                		myWriterRep.write(result.get(rep)+" \n");
			                	rep++;
			                	}
			                	myWriterRep.write("Total >>>"+result.size()+" \n");
			                	SummaryReport += result.size();
			                } catch (IOException e) {
			                	e.printStackTrace();
			                }
						
						
		     	  }else if (QCWDXP.isSelected()){
		     		  	
		     		 Files.move(new File(s+"\\QC_Wrap").toPath(), new File(s+"\\EXAM_DXP\\QC_Wrap").toPath(), StandardCopyOption.REPLACE_EXISTING);
		     		 	long size = Files.walk(Paths.get(s+"\\EXAM_DXP\\QC_Wrap")).mapToLong( p -> p.toFile().length() ).sum();

						//System.out.println("size "+ size);
						if(size == 0) {
				     		 File folder = new File(s+"\\EXAM_DXP\\Sampling_Wrapping_1");
					     		File[] listOfFiles = folder.listFiles();
					     		for (int i = 0; i < listOfFiles.length; i++) {
					     		  if (listOfFiles[i].isFile()) {
					     		  //  System.out.println("File " + listOfFiles[i].getName());
					     		   if (listOfFiles[i].getName().indexOf("100%")!=0) {
					     		   File file = new File(s+"\\EXAM_DXP\\Sampling_Wrapping_1\\"+listOfFiles[i].getName());
					     		   File file2 = new File(s+"\\EXAM_DXP\\Sampling_Wrapping_1\\QC_"+listOfFiles[i].getName());
					     		   file.renameTo(file2);
					     		  break;
					     		   }
					     		  }
					     		}
						}
						
		                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_DXP\\QC_Wrap"))) {
			                myWriterRep.write("Folder : EXAM_DXP : QC_Wrap \n");
			                	List<String> result = walk.map(x -> x.toString())
			                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
			                	int rep = 0;
			                	while(rep < result.size()) {
			                		myWriterRep.write(result.get(rep)+" \n");
			                	rep++;
			                	}
			                	myWriterRep.write("Total >>>"+result.size()+" \n");
			                	SummaryReport += result.size();
			                } catch (IOException e) {
			                	e.printStackTrace();
			                }
		     	  }
		     	  
		     	  if(QCETKS.isSelected()) {
						Files.move(new File(s+"\\QC_Env").toPath(), new File(s+"\\EXAM_TKS\\QC_Env").toPath(), StandardCopyOption.REPLACE_EXISTING);
					
						long size = Files.walk(Paths.get(s+"\\EXAM_TKS\\QC_Env")).mapToLong( p -> p.toFile().length() ).sum();
						//System.out.println("size "+ size);
						if(size == 0) {
				     		 File folder = new File(s+"\\EXAM_TKS\\Sampling_ENV");
					     		File[] listOfFiles = folder.listFiles();
					     		for (int i = 0; i < listOfFiles.length; i++) {
					     		  if (listOfFiles[i].isFile()) {
					     		  //  System.out.println("File " + listOfFiles[i].getName());
					     		   if (listOfFiles[i].getName().indexOf("100%")!=0) {
					     		   File file = new File(s+"\\EXAM_TKS\\Sampling_ENV\\"+listOfFiles[i].getName());
					     		   File file2 = new File(s+"\\EXAM_TKS\\Sampling_ENV\\QC_"+listOfFiles[i].getName());
					     		   file.renameTo(file2);
					     		   break;
					     		   }
					     		  }
					     		}
						}
						
		                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_TKS\\QC_Env"))) {
			                myWriterRep.write("Folder : EXAM_TKS : QC_Env \n");
			                	List<String> result = walk.map(x -> x.toString())
			                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
			                	int rep = 0;
			                	while(rep < result.size()) {
			                		myWriterRep.write(result.get(rep)+" \n");
			                	rep++;
			                	}
			                	myWriterRep.write("Total >>>"+result.size()+" \n");
			                	SummaryReport += result.size();
			                } catch (IOException e) {
			                	e.printStackTrace();
			                }
						
		     	  }else if (QCEDXP.isSelected()){
		     		 Files.move(new File(s+"\\QC_Env").toPath(), new File(s+"\\EXAM_DXP\\QC_Env").toPath(), StandardCopyOption.REPLACE_EXISTING);
		     		
						long size = Files.walk(Paths.get(s+"\\EXAM_DXP\\QC_Env")).mapToLong( p -> p.toFile().length() ).sum();
						//System.out.println("size "+ size);
						if(size == 0) {
				     		 File folder = new File(s+"\\EXAM_DXP\\Sampling_ENV");
					     		File[] listOfFiles = folder.listFiles();
					     		for (int i = 0; i < listOfFiles.length; i++) {
					     		  if (listOfFiles[i].isFile()) {
					     		//    System.out.println("File " + listOfFiles[i].getName());
					     		   if (listOfFiles[i].getName().indexOf("100%")!=0) {
					     		   File file = new File(s+"\\EXAM_DXP\\Sampling_ENV\\"+listOfFiles[i].getName());
					     		   File file2 = new File(s+"\\EXAM_DXP\\Sampling_ENV\\QC_"+listOfFiles[i].getName());
					     		   file.renameTo(file2);
					     		   break;
					     		   }
					     		  }
					     		}
						}
						
		                try (Stream<Path> walk = Files.walk(Paths.get(s+"\\EXAM_DXP\\QC_Env"))) {
			                myWriterRep.write("Folder : EXAM_DXP : QC_Env \n");
			                	List<String> result = walk.map(x -> x.toString())
			                			.filter(f -> f.endsWith(".pdf")).collect(Collectors.toList());
			                	int rep = 0;
			                	while(rep < result.size()) {
			                		myWriterRep.write(result.get(rep)+" \n");
			                	rep++;
			                	}
			                	myWriterRep.write("Total >>>"+result.size()+" \n");
			                	SummaryReport += result.size();
			                } catch (IOException e) {
			                	e.printStackTrace();
			                }
		     	  }
		     	  	myWriterRep.write("Total File >>>"+SummaryReport+" \n");
	                myWriterRep.close();//Close File Report
			     	 Frame appZip = new Frame();
			     	 appZip.pack(s+"\\EXAM_TKS\\", s+"\\EXAM_TKS.zip");
			     	 appZip.pack(s+"\\EXAM_DXP\\", s+"\\EXAM_DXP.zip");
			     	 
			     	 JOptionPane.showMessageDialog ( null, "Zip File Success" );
			     	frmJavaMangeBatch.dispose();
		     	  }else {
		     		 JOptionPane.showMessageDialog ( null, "Please Select All Case" );
		     	  }

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						JOptionPane.showMessageDialog ( null, "Error Please Check your Folder!!! \n "+e );
						frmJavaMangeBatch.dispose();
					}
				
			}

			private boolean SelectedAll() {
				boolean check = false;
				int countChk = 0;
			 if(Seal1TKS.isSelected()) {
				 
				 countChk++;
		   	  }else if (Sea1DXP.isSelected()){
		   		
		   		countChk++;
		   	  }
		   	  
		   	  if(Seal2TKS.isSelected()) {
		   		
		   		countChk++;
		   	  }else if (Seal2DXP.isSelected()){
		   		
		   		countChk++;
		   	  }
		   	  
		   	  if(Wrap1TKS.isSelected()) {
		   		
		   		countChk++;
		   	  }else if (Wrap1DXP.isSelected()){
		   		
		   		countChk++;
		   	  }
		   	  
		   	  if(Wrap2TKS.isSelected()) {
		   		
		   		countChk++;
		   	  }else if (Wrap2DXP.isSelected()){
		   		
		   		countChk++;
		   	  }
		   	  
		   	  if(EnvTKS.isSelected()) {
		   		
		   		countChk++;
		   	  }else if (EnvDXP.isSelected()){
		   		
		   		countChk++;
		   	  }
		   	  
		   	  if(QCSTKS.isSelected()) {
		   		
		   		countChk++;
		   	  }else if (QCSDXP.isSelected()){
		   		
		   		countChk++;
		   	  }
		   	  
		   	  if(QCWTKS.isSelected()) {
		   		
		   		countChk++;
		   	  }else if (QCWDXP.isSelected()){
		   		
		   		countChk++;
		   	  }
		   	  if(QCETKS.isSelected()) {
		   		
		   		countChk++;
		   	  }else if (QCEDXP.isSelected()){
		   		
		   		countChk++;
		   	  }
		   	  
		   	  if(countChk ==8) {
		   		check = true;
		   	  }else {
		   		check = false;
		   	  }
		   	  
				return check;
			}
		});
		btnNewButton.setBounds(154, 267, 89, 23);
		frmJavaMangeBatch.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				buttonGroup_2.clearSelection();
				buttonGroup_3.clearSelection();
				buttonGroup_4.clearSelection();
				buttonGroup_5.clearSelection();
				buttonGroup_6.clearSelection();
				buttonGroup_7.clearSelection();
			}
		});
		btnNewButton_1.setBounds(255, 267, 89, 23);
		frmJavaMangeBatch.getContentPane().add(btnNewButton_1);
		

	}
	
	public static void pack(String sourceDirPath, String zipFilePath) throws IOException {
	    Path p = Files.createFile(Paths.get(zipFilePath));
	    Path pp = Paths.get(sourceDirPath);
	    try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p));
	        Stream<Path> paths = Files.walk(pp)) {
	        paths
	          .filter(path -> !Files.isDirectory(path))
	          .forEach(path -> {
	              ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
	              try {
	                  zs.putNextEntry(zipEntry);
	                  Files.copy(path, zs);
	                  zs.closeEntry();
	            } catch (IOException e) {
	                System.err.println(e);
	            }
	          });
	    }
	}

}
