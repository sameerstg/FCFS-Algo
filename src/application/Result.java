package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Result implements Initializable{
	@FXML 
	TableView<Data> table;
	@FXML 
	TableColumn<Data,String> pnumber;
	@FXML 
	TableColumn<Data,String> atime;
	@FXML 
	TableColumn<Data,String> btime;
	
	@FXML 
	TableColumn<Data,String> ctime;
	
	@FXML 
	TableColumn<Data,String> ttime;
	@FXML 
	TableColumn<Data,String> wtime;
	@FXML 
	Label avgwait;
	@FXML 
	Label totaltime;
	
	Data data1= Data.getInstance();
	
	int i,numberOfPerson,burst_time[],TT[],WT[];
	public float avg_wait,avg_TT;
	
	final ObservableList<Data> data = FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		avgwait.setText(data1.avgwait);
		totaltime.setText(data1.avgtotlatime);
		
		for(i=0;i<data1.numberOfPerson;i++)
		{
			data.add(new Data(Integer.toString(data1.pn[i]),Integer.toString(data1.at[i]) ,Integer.toString(data1.bt[i]),Integer.toString(data1.ct[i]) ,Integer.toString(data1.tt[i]) ,Integer.toString(data1.wt[i])));	
		}
		
			
		
		table.setItems(data);
		pnumber.setCellValueFactory(new PropertyValueFactory<>("noOfPerson"));
		atime.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
		btime.setCellValueFactory(new PropertyValueFactory<>("bursttime"));
		ctime.setCellValueFactory(new PropertyValueFactory<>("completitionTime"));
		
		ttime.setCellValueFactory(new PropertyValueFactory<>("totalTime"));
		wtime.setCellValueFactory(new PropertyValueFactory<>("waitingTime"));
		
	}
	
	void Cal() {
		System.out.println("Enter the number of process");
        Scanner in = new Scanner(System.in);
        int numberOfProcesses = in.nextInt();

        int pid[] = new int[numberOfProcesses];
        int bt[] = new int[numberOfProcesses];
        int ar[] = new int[numberOfProcesses];
        int ct[] = new int[numberOfProcesses];
        int ta[] = new int[numberOfProcesses];
        int wt[] = new int[numberOfProcesses];

        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.println("Enter process " + (i+1) + " arrival time: ");
            ar[i] = in.nextInt();
            System.out.println("Enter process " + (i+1) + " brust time: ");
            bt[i] = in.nextInt();
            pid[i] = i+1;
        }
        int temp;
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = i+1; j < numberOfProcesses; j++) {

                if(ar[i] > ar[j]) {
                    temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;

                    temp = pid[i];
                    pid[i] = pid[j];
                    pid[j] = temp;
                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;
                }
            }
        }

        System.out.println();
        ct[0] = bt[0] + ar[0];
        for(int i = 1; i < numberOfProcesses; i++) {
            ct[i] = ct[i - 1] + bt[i];
        }
        for(int i = 0; i < numberOfProcesses; i++) {
            ta[i] = ct[i] - ar[i];
            wt[i] = ta[i] - bt[i];
        }
        System.out.println("Process\t\tAT\t\tBT\t\tCT\t\tTAT\t\tWT");
        avg_wait = 0;
        avg_TT = 0;
        data1.numberOfPerson = numberOfProcesses;
        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.println(pid[i]+"\t\t\t" + ar[i] + "\t\t" + bt[i]+ "\t\t" + ct[i]+ "\t\t" + ta[i]+ "\t\t" + wt[i]);
            data1.pn[i] = pid[i];
            data1.at[i] = ar[i];
            data1.bt[i] = bt[i];
            data1.ct[i] = ct[i];
			data1.tt[i] = ta[i];
			data1.wt[i] = wt[i];
			avg_wait += wt[i];
			avg_TT += ta[i];
            
        }
        avg_TT/= numberOfProcesses;
        avg_wait/=numberOfProcesses;
        data1.avgwait = "Avg. Waiting Time"+Float.toString(avg_wait);
		data1.avgtotlatime = "Avg. Total Time"+Float.toString(avg_TT);
        System.out.println("gantt chart: ");
        for(int i = 0; i < numberOfProcesses; i++) {
            System.out.print("P" + pid[i] +" ");
        }
        }


}
