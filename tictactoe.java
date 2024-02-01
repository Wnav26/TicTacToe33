package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class tictactoe implements ActionListener{
	private String winner="";
	private Boolean turn= true;
	private JButton [][]jbutton=new JButton[3][3];
	private JFrame frame = new JFrame();
	public tictactoe() {
		
		this.frame=new JFrame("TIC TAC TOE");
		
		
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		
		frame.setLayout(new GridLayout(3,3));
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				jbutton[i][j]=new JButton();
				frame.add(jbutton[i][j]);
				jbutton[i][j].setFont(new Font("MV Boli",Font.BOLD,120));
				jbutton[i][j].setFocusable(false);
				jbutton[i][j].addActionListener(this);
				jbutton[i][j].setBackground(Color.gray);
				jbutton[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 1));
			}
		}		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(e.getSource()==jbutton[i][j]) {
					if(turn) {
						if(jbutton[i][j].getText()=="") {
							jbutton[i][j].setText("X");
							jbutton[i][j].setForeground(Color.RED);
							turn=false;
							
						}
					}
					else {
						if(jbutton[i][j].getText()=="") {
							jbutton[i][j].setText("O");
							jbutton[i][j].setForeground(Color.PINK);
							turn=true;
					
						}
					}
				}
			}
		
		}
		int count=0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(jbutton[i][j].getText().equals("X")||jbutton[i][j].getText().equals("O")) count++;
			}
		}
		if(count>8&& winner=="")winner="HÒA";
		check();
	}
	public void check() {
	    for(int i=0;i<3;i++) {
	        if(jbutton[i][0] != null && jbutton[i][0].getText().equals("X") &&
	           jbutton[i][1] != null && jbutton[i][1].getText().equals("X") &&
	           jbutton[i][2] != null && jbutton[i][2].getText().equals("X")) {
	            winner="X win";
	        } else if(jbutton[i][0] != null && jbutton[i][0].getText().equals("O") &&
	                  jbutton[i][1] != null && jbutton[i][1].getText().equals("O") &&
	                  jbutton[i][2] != null && jbutton[i][2].getText().equals("O")) {
	            winner="O win";
	        } else if(jbutton[0][i] != null && jbutton[0][i].getText().equals("X") &&
	                  jbutton[1][i] != null && jbutton[1][i].getText().equals("X") &&
	                  jbutton[2][i] != null && jbutton[2][i].getText().equals("X")) {
	            winner="X win";
	        } else if(jbutton[0][i] != null && jbutton[0][i].getText().equals("O") &&
	                  jbutton[1][i] != null && jbutton[1][i].getText().equals("O") &&
	                  jbutton[2][i] != null && jbutton[2][i].getText().equals("O")) {
	            winner="O win";
	        }
	    }
	    if(winner=="") {
	        if(jbutton[0][0] != null && jbutton[0][0].getText().equals("X") &&
	           jbutton[1][1] != null && jbutton[1][1].getText().equals("X") &&
	           jbutton[2][2] != null && jbutton[2][2].getText().equals("X")) {
	            winner= "X win";
	        } else if(jbutton[0][2] != null && jbutton[0][2].getText().equals("X") &&
	                  jbutton[1][1] != null && jbutton[1][1].getText().equals("X") &&
	                  jbutton[2][0] != null && jbutton[2][0].getText().equals("X")) {
	        	winner= "X win";
	        }
	        else if(jbutton[0][0] != null && jbutton[0][0].getText().equals("O") &&
			           jbutton[1][1] != null && jbutton[1][1].getText().equals("O") &&
			           jbutton[2][2] != null && jbutton[2][2].getText().equals("O")) {
	            winner= "O win";
			} else if(jbutton[0][2] != null && jbutton[0][2].getText().equals("O") &&
			                  jbutton[1][1] != null && jbutton[1][1].getText().equals("O") &&
			                  jbutton[2][0] != null && jbutton[2][0].getText().equals("O")) {
	        	winner= "O win";
	        }
	    }
	    
		if(winner!="") {
			
			JOptionPane.showMessageDialog(frame,winner );
			reset();
			winner="";
			
		}
			
	}
	public void reset() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				jbutton[i][j].setText("");
			}
		}
	}
	public static void main(String[] args) {
		new tictactoe();
	}
}
