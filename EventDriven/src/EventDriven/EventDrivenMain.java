package EventDriven;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import RegistrationSystemOOP.*;
import java.util.ArrayList;
public class EventDrivenMain {
	public static int capacityy = 0;
	public static String eventName = "";
	public static String locationn = "";
	public static int datee = 0;
	public static String durationn = "";
	public static void main(String[] args) {
		
		EventManager manager = new EventManager();
		JFrame frame = new JFrame("Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        
        frame.setLayout(new GridLayout(6, 1));
        
        JPanel panel1 = new JPanel();
        JLabel text = new JLabel("1.");
        JButton button = new JButton("Add Event");
        panel1.add(text);
        panel1.add(button);
        frame.add(panel1);
        frame.setVisible(true);
        
        
        JPanel panel2 = new JPanel();
        JLabel text2 = new JLabel("2.");
        JButton button2 = new JButton("Add Online Event");
        panel2.add(text2);
        panel2.add(button2);
        frame.add(panel2);
        frame.setVisible(true);
        
        JPanel panel3 = new JPanel();
        JLabel text3 = new JLabel("3.");
        JButton button3 = new JButton("Show Events");
        panel3.add(text3);
        panel3.add(button3);
        frame.add(panel3);
        frame.setVisible(true);
        
        JPanel panel4 = new JPanel();
        JLabel text4 = new JLabel("4.");
        JButton button4 = new JButton("Show Events Sorted");
        panel4.add(text4);
        panel4.add(button4);
        frame.add(panel4);
        frame.setVisible(true);
        
        JPanel panel5 = new JPanel();
        JLabel text5 = new JLabel("5.");
        JButton button5 = new JButton("Add Participant");
        panel5.add(text5);
        panel5.add(button5);
        frame.add(panel5);
        frame.setVisible(true);
        
        JPanel panel6 = new JPanel();
        JLabel text6 = new JLabel("6.");
        JButton button6 = new JButton("Print Regestration Report");
        panel6.add(text6);
        panel6.add(button6);
        frame.add(panel6);
        frame.setVisible(true);
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addEventFrame = new JFrame("Add Event");
                addEventFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                addEventFrame.setSize(400, 300);
                addEventFrame.setLayout(new GridLayout(7,2,10,10));
                

                JLabel lbl = new JLabel("Enter the event name: ");
                JTextField nameInput = new JTextField(20);

                nameInput.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            
                            System.out.println("Event Saved: " + eventName);
                        }
                    }
                });

                addEventFrame.add(lbl);
                addEventFrame.add(nameInput);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
                JLabel lbl2 = new JLabel("Enter the date in the syntax YYYYMMDD: ");
                JTextField date = new JTextField(20);

                date.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            
                            System.out.println("Event Saved: " + datee);
                        }
                    }
                });

                addEventFrame.add(lbl2);
                addEventFrame.add(date);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
                JLabel lbl3 = new JLabel("Enter the location: ");
                JTextField location = new JTextField(20);

                location.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            
                            System.out.println("Event Saved: " + locationn);
                        }
                    }
                });

                addEventFrame.add(lbl3);
                addEventFrame.add(location);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
                JLabel lbl4 = new JLabel("Enter the Capacity: ");
                JTextField capacity = new JTextField(20);

                capacity.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            
                            System.out.println("Event Saved: " + capacityy);
                        }
                    }
                });

                addEventFrame.add(lbl4);
                addEventFrame.add(capacity);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
                JLabel lbl5 = new JLabel("Enter the duration: ");
                JTextField duration = new JTextField(20);

                duration.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            
                            System.out.println("Event Saved: " + durationn);
                        }
                    }
                });

                addEventFrame.add(lbl5);
                addEventFrame.add(duration);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
                JButton buttonSubmit = new JButton("Submit");
                buttonSubmit.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		durationn = duration.getText(); 
                		capacityy = Integer.parseInt(capacity.getText()); 
                		locationn = location.getText(); 
                		datee = Integer.parseInt(date.getText()); 
                		eventName = nameInput.getText(); 
                		
                		manager.addStandardEvent(eventName, datee, durationn, locationn, capacityy);
                		System.out.println("Event Has been added.[ " + eventName + " ]");
                		addEventFrame.dispose();
                	}
                });
                
                addEventFrame.add(buttonSubmit);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
                
                
            }
        });
        
        
        
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame addEventFrame = new JFrame("Add Online Event");
                addEventFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
                addEventFrame.setSize(400, 300);
                addEventFrame.setLayout(new GridLayout(7,2,10,10));
                

                JLabel lbl = new JLabel("Enter the event name: ");
                JTextField nameInput = new JTextField(20);

                nameInput.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            
                            System.out.println("Event Saved: " + eventName);
                        }
                    }
                });

                addEventFrame.add(lbl);
                addEventFrame.add(nameInput);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
                JLabel lbl2 = new JLabel("Enter the date in the syntax YYYYMMDD: ");
                JTextField date = new JTextField(20);

                date.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            
                            System.out.println("Event Saved: " + datee);
                        }
                    }
                });

                addEventFrame.add(lbl2);
                addEventFrame.add(date);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
                JLabel lbl3 = new JLabel("Enter the Platform: ");
                JTextField location = new JTextField(20);

                location.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            
                            System.out.println("Event Saved: " + locationn);
                        }
                    }
                });

                addEventFrame.add(lbl3);
                addEventFrame.add(location);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
                JLabel lbl4 = new JLabel("Enter the Capacity: ");
                JTextField capacity = new JTextField(20);

                capacity.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            
                            System.out.println("Event Saved: " + capacityy);
                        }
                    }
                });

                addEventFrame.add(lbl4);
                addEventFrame.add(capacity);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
                JLabel lbl5 = new JLabel("Enter the duration: ");
                JTextField duration = new JTextField(20);

                duration.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                            
                            System.out.println("Event Saved: " + durationn);
                        }
                    }
                });

                addEventFrame.add(lbl5);
                addEventFrame.add(duration);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
                
                JButton buttonSubmit = new JButton("Submit");
                buttonSubmit.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		durationn = duration.getText(); 
                		capacityy = Integer.parseInt(capacity.getText()); 
                		locationn = location.getText(); 
                		datee = Integer.parseInt(date.getText()); 
                		eventName = nameInput.getText(); 
                		manager.addStandardEvent(eventName, datee, durationn, locationn, capacityy);
                		System.out.println("Event Has been added.[ " + eventName + " ]");
                		addEventFrame.dispose();
                	}
                });
                
                addEventFrame.add(buttonSubmit);
                addEventFrame.setLocationRelativeTo(null);
                addEventFrame.setVisible(true);
                
            }
        });
        
        
        button3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		final int[] currentPage = {0};
        		JFrame showFrame = new JFrame("View Events");
                showFrame.setSize(500, 400);
                showFrame.setLayout(new BorderLayout());

                
                JPanel listPanel = new JPanel(new GridLayout(25, 1));
                JPanel navPanel = new JPanel();
                JButton prevBtn = new JButton("Previous");
                JButton nextBtn = new JButton("Next");
                
                
        		
        		ArrayList<RegistrationSystemOOP.Event> events = manager.getEvents();
        		listPanel.removeAll();
        		for(int i = 0; i<=4 ; i++) {
        			if (i < events.size()) {
						listPanel.add(new JLabel((i+1) + ". " + events.get(i).getName()));
						listPanel.add(new JLabel("\t" + events.get(i).getDate()));
						listPanel.add(new JLabel("\t" + events.get(i).getDuration()));
						listPanel.add(new JLabel("\t" + events.get(i).getLocation()));
						listPanel.add(new JLabel("\t" + events.get(i).getType()));
					} else {
						listPanel.add(new JLabel(" "));
					}
        				
        		}
        		navPanel.add(nextBtn);
        		nextBtn.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				if ((currentPage[0] + 1) * 5 < events.size()) {
        					currentPage[0]++;
        					listPanel.removeAll();
        					for(int i = currentPage[0] * 5; i<currentPage[0] * 5 + 5 ; i++) {
        						if (i < events.size()) {
        							listPanel.add(new JLabel((i+1) + ". " + events.get(i).getName()));
        							listPanel.add(new JLabel("\t" + events.get(i).getDate()));
        							listPanel.add(new JLabel("\t" + events.get(i).getDuration()));
        							listPanel.add(new JLabel("\t" + events.get(i).getLocation()));
        							listPanel.add(new JLabel("\t" + events.get(i).getType()));
        						} else {
        							listPanel.add(new JLabel(" "));
        						}
        					}
        					navPanel.remove(nextBtn);
        					navPanel.add(prevBtn);
        					navPanel.add(nextBtn);
        					listPanel.revalidate();
        					listPanel.repaint();
        				}
        			}
        		});
        		
        		prevBtn.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				if(currentPage[0] > 0) {
        					currentPage[0]--;
        					listPanel.removeAll();
        					for(int i = currentPage[0] * 5; i<currentPage[0] * 5 + 5 ; i++) {
        						if (i < events.size()) {
        							listPanel.add(new JLabel((i+1) + ". " + events.get(i).getName()));
        							listPanel.add(new JLabel("\t" + events.get(i).getDate()));
        							listPanel.add(new JLabel("\t" + events.get(i).getDuration()));
        							listPanel.add(new JLabel("\t" + events.get(i).getLocation()));
        							listPanel.add(new JLabel("\t" + events.get(i).getType()));
        						} else {
        							listPanel.add(new JLabel(" "));
        						}
        					}
        					if(currentPage[0] == 0) {
        						navPanel.add(nextBtn);
        					} else {
        						navPanel.add(prevBtn);
        					}
        					listPanel.revalidate();
        					listPanel.repaint();
        				}
        			}
        		});
        		showFrame.add(listPanel, BorderLayout.CENTER);
                showFrame.add(navPanel, BorderLayout.SOUTH);
                showFrame.setLocationRelativeTo(null);
                showFrame.setVisible(true);
        		
        	}
        });
        
        
        button4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ArrayList<RegistrationSystemOOP.Event> events = manager.getEvents();
        		
        		
        		for(int i = 0 ; i<events.size() - 1 ; i++) {
        			for(int j = 0 ; j<events.size() - i - 1 ; j++) {
        				if(events.get(j).getDateAsInteger() > events.get(j+1).getDateAsInteger()) {
        					RegistrationSystemOOP.Event temp = events.get(j);
        					events.set(j, events.get(j+1));
        					events.set(j+1, temp);
        					
        				}
        			}
        		}
        		final int[] currentPage = {0};
        		JFrame showFrame = new JFrame("View Events Sorted");
                showFrame.setSize(500, 400);
                showFrame.setLayout(new BorderLayout());

                
                JPanel listPanel = new JPanel(new GridLayout(25, 1));
                JPanel navPanel = new JPanel();
                JButton prevBtn = new JButton("Previous");
                JButton nextBtn = new JButton("Next");
                
                
        		
        		
        		listPanel.removeAll();
        		for(int i = 0; i<=4 ; i++) {
        			if (i < events.size()) {
						listPanel.add(new JLabel((events.get(i).getId()) + ". " + events.get(i).getName()));
						listPanel.add(new JLabel("\t" + events.get(i).getDate()));
						listPanel.add(new JLabel("\t" + events.get(i).getDuration()));
						listPanel.add(new JLabel("\t" + events.get(i).getLocation()));
						listPanel.add(new JLabel("\t" + events.get(i).getType()));
					} else {
						listPanel.add(new JLabel(" "));
					}
        				
        		}
        		navPanel.add(nextBtn);
        		nextBtn.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				if ((currentPage[0] + 1) * 5 < events.size()) {
        					currentPage[0]++;
        					listPanel.removeAll();
        					for(int i = currentPage[0] * 5; i<currentPage[0] * 5 + 5 ; i++) {
        						if (i < events.size()) {
        							listPanel.add(new JLabel((events.get(i).getId()) + ". " + events.get(i).getName()));
        							listPanel.add(new JLabel("\t" + events.get(i).getDate()));
        							listPanel.add(new JLabel("\t" + events.get(i).getDuration()));
        							listPanel.add(new JLabel("\t" + events.get(i).getLocation()));
        							listPanel.add(new JLabel("\t" + events.get(i).getType()));
        						} else {
        							listPanel.add(new JLabel(" "));
        						}
        					}
        					navPanel.remove(nextBtn);
        					navPanel.add(prevBtn);
        					navPanel.add(nextBtn);
        					listPanel.revalidate();
        					listPanel.repaint();
        				}
        			}
        		});
        		
        		prevBtn.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				if(currentPage[0] > 0) {
        					currentPage[0]--;
        					listPanel.removeAll();
        					for(int i = currentPage[0] * 5; i<currentPage[0] * 5 + 5 ; i++) {
        						if (i < events.size()) {
        							listPanel.add(new JLabel((events.get(i).getId()) + ". " + events.get(i).getName()));
        							listPanel.add(new JLabel("\t" + events.get(i).getDate()));
        							listPanel.add(new JLabel("\t" + events.get(i).getDuration()));
        							listPanel.add(new JLabel("\t" + events.get(i).getLocation()));
        							listPanel.add(new JLabel("\t" + events.get(i).getType()));
        						} else {
        							listPanel.add(new JLabel(" "));
        						}
        					}
        					if(currentPage[0] == 0) {
        						navPanel.add(nextBtn);
        					} else {
        						navPanel.add(prevBtn);
        					}
        					listPanel.revalidate();
        					listPanel.repaint();
        				}
        			}
        		});
        		showFrame.add(listPanel, BorderLayout.CENTER);
                showFrame.add(navPanel, BorderLayout.SOUTH);
                showFrame.setLocationRelativeTo(null);
                showFrame.setVisible(true);
        		
        	
        		
        	}
        });
        
        
	}
	

}
