package gui;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import core.GUIAssets;
import core.HourAssets;
import dbAdmin.DBAdmin;
import pojos.Accommodation;
import pojos.Agency;
import pojos.AgencyType;
import pojos.Airport;
import pojos.Airline;
import pojos.Country;
import pojos.City;
import pojos.MaxEmployees;
import pojos.Other;
import pojos.RoomType;
import pojos.Travel;
import pojos.TravelType;
import pojos.Flight;
import pojos.FlightPair;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;


public class Window extends JFrame{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private ArrayList<JPanel> mainMenus = null;

    private final int rootWidth  = 850;
    private final int rootHeight = 500;
    
    private GUIAssets guiAssets = new GUIAssets();
    private DBAdmin dbAdmin = new DBAdmin();

    public Window() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, rootWidth, rootHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setResizable(false);

        setContentPane(contentPane);

        mainMenus = new ArrayList<JPanel>();

        genMenues();
    }

    public void genMenues() {

    	for (int i = 0; i < 6; i++) {
    		this.mainMenus.add(new JPanel());
    	}
    	// 0: Welcome
    	// 1: Login
    	// 2: SignUp
    	// 3: Menu
    	// 4: MenuTravel 
    	// 5: MenuEvent
    	
    	    	
        this.genWelcome();
        this.genLogin();
        this.genSignup();
        //this.genMenu("", "");

        for (JPanel panel: mainMenus) {
            this.add(panel);
        }
        changeMenu(0);
    }
    
    private void genWelcome() {
    	
    	JPanel p = mainMenus.get(0);
        p.removeAll();
        p.revalidate();
        p.setBounds(0, 0, rootWidth, rootHeight);
        p.setLayout(null);
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	// Cambiar a login.
            	genLogin();
                changeMenu(1);
            }
        });

        JLabel l = new JLabel("WELCOME");
        l.setOpaque(true);
        l.setBorder(new EmptyBorder(5, 5, 5, 5));
        int greyColor = 0x88;
        l.setBackground(new Color(greyColor, greyColor, greyColor));
        l.setBounds(0, 160, rootWidth, 120);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setVerticalAlignment(SwingConstants.CENTER);

        // Esto es para que el focus no se vea.
        // (Arregla un bug visual)
		JTextField tf = new JTextField();

        p.add(l);
		p.add(tf);

    }
    
    private void genLogin() {
    	
    	JPanel p = mainMenus.get(1);
        p.removeAll();
        p.revalidate();
        p.setBounds(0, 0, rootWidth, rootHeight);
        p.setLayout(null);
        
        int labelXPos   = 330;
        int labelYPos   = 160;
        int xSeparation =  80;
        int ySeparation =  30;
        
        JLabel nameLabel = new JLabel("Usuario:");
        nameLabel.setVisible(true);
        nameLabel.setBounds(labelXPos, labelYPos, xSeparation, 20);
        nameLabel.setOpaque(true);
        
		JTextField nameField = new JTextField();
		nameField.setBounds(labelXPos + xSeparation, labelYPos, 100, 20);
		nameField.setColumns(32);

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setVisible(true);
        passwordLabel.setBounds(labelXPos, labelYPos + ySeparation, xSeparation, 20);
        passwordLabel.setOpaque(true);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(labelXPos + xSeparation , labelYPos + ySeparation, 100, 20);
		passwordField.setColumns(32);
        
        p.add(nameLabel);
        p.add(nameField);
        p.add(passwordLabel);
        p.add(passwordField);

        int buttonsYPos = 230;
        
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.setBounds(300, buttonsYPos, 120, 20);
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (dbAdmin.existsAccount(
            		nameField.getText(),
            		new String(passwordField.getPassword())
            	)) {
            		genMenu(nameField.getText(), new String(passwordField.getPassword()));
            		changeMenu(3);
            	} else {
            		JOptionPane.showMessageDialog(
	            		null,
	            		"La combinación de nombre y usuario no existe.",
	            		"Error de inicio de sesión",
	            		JOptionPane.ERROR_MESSAGE
	            	);
            	}
            }
        });
        
        JButton newAgencyButton = new JButton("Nueva agencia");
        newAgencyButton.setBounds(440, buttonsYPos, 120, 20);
        newAgencyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	genSignup();
            	changeMenu(2);
            }
        });
        
        p.add(loginButton);
        p.add(newAgencyButton);
        
    }

    private void genSignup() {
    	
    	JPanel p = mainMenus.get(2);
        p.removeAll();
        p.revalidate();
        p.setBounds(0, 0, rootWidth, rootHeight);
        p.setLayout(null);
        
        int[] xPos = {330, 100};
        int[] yPos = {100, 30, 30, 30, 30, 30, 30, 40};
        
        for (int i = 1; i < xPos.length; i++) {
        	xPos[i] = xPos[i - 1] + xPos[i];
        }

        for (int i = 1; i < yPos.length; i++) {
        	yPos[i] = yPos[i - 1] + yPos[i];
        }


        JLabel nameLabel = new JLabel("Usuario:");
        nameLabel.setVisible(true);
        nameLabel.setBounds(xPos[0], yPos[0], 100, 20);
        nameLabel.setOpaque(true);
        
		JTextField nameField = new JTextField();
		nameField.setBounds(xPos[1], yPos[0], 100, 20);
		nameField.setColumns(32);


        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setVisible(true);
        passwordLabel.setBounds(xPos[0], yPos[1], 100, 20);
        passwordLabel.setOpaque(true);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(xPos[1], yPos[1], 100, 20);
		passwordField.setColumns(32);


        JLabel passwordLabel2 = new JLabel("Confirma PW:");
        passwordLabel2.setVisible(true);
        passwordLabel2.setBounds(xPos[0], yPos[2], 100, 20);
        passwordLabel2.setOpaque(true);

		JPasswordField passwordField2 = new JPasswordField();
		passwordField2.setBounds(xPos[1], yPos[2], 100, 20);
		passwordField2.setColumns(32);


        JLabel colorLabel = new JLabel("Color:");
        JTextField colorField = new JTextField();
        JLabel colorLabel2 = new JLabel();

        colorLabel.setVisible(true);
        colorLabel.setBounds(xPos[0], yPos[3], 50, 20);
        colorLabel.setOpaque(true);

		colorField.setBounds(xPos[1] - 50, yPos[3], 80, 20);
		colorField.setColumns(32);
		colorField.setText("#000000");
		colorField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				// Nada.
            }

			public void focusLost(FocusEvent e) {
				String hexColor = colorField.getText();
				
				if (!guiAssets.checkValidHexColor(hexColor)) {
					hexColor = "#000000";
					colorField.setText(hexColor);
				}

				int[] rgb = guiAssets.hexToIntArray(hexColor);
				int r = rgb[0];
				int g = rgb[1];
				int b = rgb[2];
				colorLabel2.setBackground(new Color(r, g, b));
			}
		});

        colorLabel2.setVisible(true);
        colorLabel2.setBounds(xPos[1] + 50, yPos[3], 40, 20);
        colorLabel2.setBackground(new Color(0, 0, 0));
        colorLabel2.setOpaque(true);
        colorLabel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				Color color = JColorChooser.showDialog(
					null,
					"Escoge el color.",
					new Color(0, 0, 0)
				);
				
				if (null != color) {
					colorField.setText(String.format(
						"#%02X%02X%02X",
						color.getRed(),
						color.getGreen(),
						color.getBlue()
					));
					colorLabel2.setBackground(color);
				}
            }
        });
        

        JLabel employeesLabel = new JLabel("Num. Empleados:");
        JComboBox<String> employeesCB = new JComboBox<String>();
        ArrayList<MaxEmployees> maxEmployees = dbAdmin.getMaxEmployees();

        for (MaxEmployees maxEmployee: maxEmployees) {
        	employeesCB.addItem(maxEmployee.getMessage());
        }
        
        employeesLabel.setBounds(xPos[0], yPos[4], 100, 20);
        employeesCB.setBounds(xPos[1], yPos[4], 220, 20);
        
        
        JLabel agencyTypeLabel = new JLabel("Tipo agencia:");
        JComboBox<String> agencyTypeCB = new JComboBox<String>();
        ArrayList<AgencyType> agencyTypes = dbAdmin.getAgencyTypes();

        for (AgencyType agencyType: agencyTypes) {
        	agencyTypeCB.addItem(agencyType.getName());
        }
        
        agencyTypeLabel.setBounds(xPos[0], yPos[5], 100, 20);
        agencyTypeCB.setBounds(xPos[1], yPos[5], 120, 20);
        
        
        JLabel logoLabel = new JLabel("Logo:");
        JTextField logoField = new JTextField();
        
        logoLabel.setBounds(xPos[0], yPos[6], 100, 20);
        logoField.setBounds(xPos[1], yPos[6], 100, 20);
        
        
        DBAdmin dbAdmin = this.dbAdmin;
        JButton okButton = new JButton("Confirmar");
        okButton.setBounds(xPos[0] - 10, yPos[7], 100, 20);
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (nameField.getText().length() > 32) {
	            	JOptionPane.showMessageDialog(
	            		null,
	            		"El nombre debe tener como máximo 32 caracteres.",
	            		"Error de nombre",
	            		JOptionPane.ERROR_MESSAGE
	            	);
            	} else if (
            		new String(passwordField.getPassword()).length() < 8 ||
                    new String(passwordField.getPassword()).length() > 32
                ) {      
            		JOptionPane.showMessageDialog(
	            		null,
	            		"La contraseña debe ser de 8 caracteres como mínimo y 32 como máximo.",
	            		"Error de contraseña",
	            		JOptionPane.ERROR_MESSAGE
	            	);
            	} else if (!new String(passwordField.getPassword()).equals(new String(passwordField2.getPassword()))) {
            		JOptionPane.showMessageDialog(
	            		null,
	            		"Las contraseñas no coinciden.",
	            		"Error de contraseña",
	            		JOptionPane.ERROR_MESSAGE
	            	);
            	} else if (guiAssets.urlImgValida(logoField.getText())) {
            		JOptionPane.showMessageDialog(
	            		null,
	            		"La url no es válida.",
	            		"Error de contraseña",
	            		JOptionPane.ERROR_MESSAGE
	            	);
            	} else {
                	AgencyType agencyType = null;
                	String agencyTypeValue = (String)agencyTypeCB.getSelectedItem();
                	
                	for (AgencyType at: agencyTypes) {
                		if (at.getName() == agencyTypeValue) {
                			agencyType = at;
                			break;
                		}
                	}
                	
                	MaxEmployees maxEmployee = null;
                	String maxEmployeesValue = (String)employeesCB.getSelectedItem();
                	
                	for (MaxEmployees me: maxEmployees) {
                		if (me.getMessage() == maxEmployeesValue) {
                			maxEmployee = me;
                			break;
                		}
                	}
                	
                	Agency agency = new Agency();
                	agency.setName(nameField.getText());
                	agency.setPassword(new String(passwordField.getPassword()));
                	agency.setLogo(logoField.getText());
                	agency.setColor(colorField.getText());
                	agency.setAgencyType(agencyType);
                	agency.setMaxEmployees(maxEmployee);
                	
                	dbAdmin.insertAgency(agency);
                	
                	genMenu(agency.getName(), agency.getPassword());
                	changeMenu(3);
            	}
            }
        });

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(xPos[1] + 10, yPos[7], 100, 20);
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	genLogin();
            	changeMenu(1);
            }
        });
		

        p.add(nameLabel);
        p.add(nameField);
        p.add(passwordLabel);
        p.add(passwordField);
        p.add(passwordLabel2);
        p.add(passwordField2);
        p.add(colorLabel);
        p.add(colorField);
        p.add(colorLabel2);
        p.add(employeesLabel);
        p.add(employeesCB);
        p.add(agencyTypeLabel);
        p.add(agencyTypeCB);
        p.add(logoLabel);
        p.add(logoField);
        p.add(okButton);
        p.add(cancelButton);
    }

    private void genMenu(String agencyName, String agencyPassword) {
    	
    	Agency agency = dbAdmin.getAgency(agencyName, agencyPassword);
    	ArrayList<Travel> travels = dbAdmin.getTravelsByAgencyId(agency.getId());
    	
    	JPanel p = mainMenus.get(3);
        p.removeAll();
        p.revalidate();
        
        p.setBounds(0, 0, rootWidth, rootHeight);
        p.setLayout(null);
        
        ////////////
        // VIAJES //
        ////////////
        
        JLabel travelsLabel = new JLabel("Viajes");
        travelsLabel.setVisible(true);
        travelsLabel.setBounds(225, 20, 50, 50);

		JButton newTravelBt = new JButton("Nuevo viaje");
		newTravelBt.setVisible(true);
		newTravelBt.setBounds(600, 35, 100, 20);
		newTravelBt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	genMenuTravel(agency, null);
            	changeMenu(4);
            	
            }
        });
        
        
        String columnsTravel_names [] = {"Nombre", "Duración", "Descripción", "Fecha", "Tipo de Viaje"};
        
        DefaultTableModel tmTravel = new DefaultTableModel(columnsTravel_names, 0) {
			private static final long serialVersionUID = 1L;

			@Override
        	public boolean isCellEditable(int row, int column) {
        		return false;
        	}
        };
        JTable jtTravel = new JTable(tmTravel);
        jtTravel.setVisible(true);
        JScrollPane spTravel = new JScrollPane(jtTravel);
        spTravel.setVisible(true);
        spTravel.setBounds(100, 75, 350, 100);
        jtTravel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (e.getClickCount() % 2 == 0 && !e.isConsumed()) {
					int selectedRow = jtTravel.getSelectedRow();
					if (selectedRow != -1) {
						for (Travel travel: travels) {
							if (travel.getName().equals(jtTravel.getModel().getValueAt(selectedRow, 0))) {
								// #TODO
								// Actualizar eventos en base a qué viaje seleccionamos
								genMenuTravel(agency, travel);
								changeMenu(4);
								break;
							}
						}
					}
            	}
            }
        });

        for (Travel travel: travels) {
        	String[] row = {
	        	travel.getName(),
	        	String.valueOf(travel.getDuration()),
	        	travel.getDescription(),
	        	travel.getTravelDate().toString(),
	        	travel.getTravelType().getDescription()
	        };
        	tmTravel.addRow(row);
        }

        JButton deleteTravelBt = new JButton("Borrar viaje");
		deleteTravelBt.setVisible(true);
		deleteTravelBt.setBounds(600, 75, 100, 20);
		deleteTravelBt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				int confirm = JOptionPane.showConfirmDialog(
					null,
					"¿Seguro que deseas borrar el viaje?",
					"Confirmación borrado",
					JOptionPane.ERROR_MESSAGE
				);
				
				if (confirm == 0) {
					dbAdmin.deleteTravel(travels.get(jtTravel.getSelectedRow()));
					genMenu(agencyName, agencyPassword);
				}
            }
        });
        
        		
        /////////////
        // EVENTOS //
        /////////////

		JLabel eventsLabel = new JLabel("Eventos");
		eventsLabel.setVisible(true);
		eventsLabel.setBounds(225, 200, 50, 50);

		JButton newEventBt = new JButton("Nuevo evento");
		newEventBt.setVisible(true);
		newEventBt.setBounds(600, 215, 100, 20);
		newEventBt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int rowSelected = jtTravel.getSelectedRow();
            	if (rowSelected != -1) {
					genMenuEvent(
						agency,
						travels.get(rowSelected),
						null,
						null,
						null
					);
					changeMenu(5);
            	} else {
            		JOptionPane.showMessageDialog(
            			null,
            			"Selecciona un viaje.",
            			"Fallo de selección",
            			JOptionPane.WARNING_MESSAGE
            		);
            	}
            }
        });
        
		String[] columnsEvents_names = {"Nombre", "Tipo", "Fecha", "Precio"};

         DefaultTableModel tmEvent = new DefaultTableModel(columnsEvents_names, 0) {
			private static final long serialVersionUID = 1L;

			@Override
        	public boolean isCellEditable(int row, int column) {
        		return false;
        	}
        };
        
        JTable jtEvent = new JTable(tmEvent);
        jtEvent.setVisible(true);
        JScrollPane spEvent = new JScrollPane(jtEvent);
        spEvent.setVisible(true);
        spEvent.setBounds(100, 250, 350, 100);
		
		
		JButton offerButton = new JButton("Generar oferta cliente");
		offerButton.setVisible(true);
		offerButton.setBounds(200, 420, 200, 20);
		offerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	// #TODO
            	// Hacer todo el apartado de nueva oferta.
            	
            }
        });

		JButton disconnectBt = new JButton("Desconectar");
		disconnectBt.setVisible(true);
		disconnectBt.setBounds(675, 430, 125, 20);
		disconnectBt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Devuelve al inicio.
            	changeMenu(1);

            }
        });

        p.add(travelsLabel);
        p.add(newTravelBt);
        p.add(deleteTravelBt);
        p.add(spTravel);
        p.add(eventsLabel);
        p.add(newEventBt);
        p.add(spEvent);
        p.add(offerButton);
        p.add(disconnectBt);
    }

    private void genMenuTravel(Agency agency, Travel travel) {
    	
    	JPanel p = mainMenus.get(4);
        p.removeAll();
        p.revalidate();
        p.setBounds(0, 0, rootWidth, rootHeight);
        p.setLayout(null);
        
        int[] xPos = {330, 100};
        int[] yPos = {100, 30, 30, 30, 30, 30, 30, 30, 40};
        
        for (int i = 1; i < xPos.length; i++) {
        	xPos[i] = xPos[i - 1] + xPos[i];
        }

        for (int i = 1; i < yPos.length; i++) {
        	yPos[i] = yPos[i - 1] + yPos[i];
        }


        JLabel nameLabel = new JLabel("Nombre viaje");
        nameLabel.setVisible(true);
        nameLabel.setBounds(xPos[0], yPos[0], 100, 20);
        nameLabel.setOpaque(true);
        
		JTextField nameField = new JTextField();
		nameField.setBounds(xPos[1], yPos[0], 100, 20);
		nameField.setColumns(32);
		
		if (null != travel) {
			nameField.setText(travel.getName());
		}
		
		
		JLabel travelTypesLabel = new JLabel("Tipo de viaje");
        JComboBox<String> travelTypesCB = new JComboBox<String>();
        ArrayList<TravelType> travelTypes = dbAdmin.getTravelTypes();

        for (TravelType travelType: travelTypes) {
        	travelTypesCB.addItem(travelType.getDescription());
        }
        
        travelTypesLabel.setBounds(xPos[0], yPos[1], 100, 20);
        travelTypesCB.setBounds(xPos[1], yPos[1], 200, 20);

		if (null != travel) {
			travelTypesCB.setSelectedItem(travel.getTravelType().getDescription());
		}

		JTextField daysField = new JTextField();

		JLabel dateStartLabel = new JLabel("Inicio viaje");
		dateStartLabel.setBounds(xPos[0], yPos[2], 100, 20);
		
		final Date[] dates = {new Date(), new Date()};


		JDatePickerImpl datePickerStart = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerStart.setBounds(xPos[1], yPos[2], 150, 30);
		datePickerStart.addActionListener(e -> {
			GregorianCalendar calendar = (GregorianCalendar) datePickerStart.getModel().getValue();
			if (null != calendar) {
				dates[0] = calendar.getTime();
				if (null != dates[1]) {
					long diff = dates[1].getTime() - dates[0].getTime();
					if (diff > 0) {
						daysField.setText(
							String.format(
								"%d",
								diff / (24 * 60 * 60 * 1000) 
							)
						);
					} else {
						daysField.setText("Error");
					}
				}
			} else {
				dates[0] = null;
			}
		});

		JLabel dateEndLabel = new JLabel("Fin viaje");
		dateEndLabel.setBounds(xPos[0], yPos[3], 100, 20);
		
		JDatePickerImpl datePickerEnd = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerEnd.setBounds(xPos[1], yPos[3], 150, 30);
		datePickerEnd.addActionListener(e -> {
			GregorianCalendar calendar = (GregorianCalendar) datePickerEnd.getModel().getValue();
			if (null != calendar) {
				dates[1] = calendar.getTime();
				if (null != dates[1]) {
					long diff = dates[1].getTime() - dates[0].getTime();
					if (diff > 0) {
						daysField.setText(
							String.format(
								"%d",
								diff / (24 * 60 * 60 * 1000) 
							)
						);
					} else {
						daysField.setText("Error");
					}
				}
			} else {
				dates[1] = null;
			}
		});
		

		JLabel daysLabel = new JLabel("Dias");
        daysLabel.setVisible(true);
        daysLabel.setBounds(xPos[0], yPos[4], 100, 20);
        daysLabel.setOpaque(true);
        
		daysField.setBounds(xPos[1], yPos[4], 100, 20);
		daysField.setColumns(32);
		daysField.setEditable(false);
		
		if (null != travel) {
			dates[0] = new Date(travel.getTravelDate().getTime());
			dates[1] = new Date(dates[0].getTime() + (travel.getDuration() * (24 * 60 * 60 * 1000)));
			
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
			datePickerStart.getJFormattedTextField().setText(df.format(dates[0]));
			datePickerEnd.getJFormattedTextField().setText(df.format(dates[1]));
			
			daysField.setText(String.valueOf(travel.getDuration()));
		}

		// #XXX Comprobar que está bien implementado
		
		JLabel countryLabel = new JLabel("País");
    	ArrayList<Country> countries = dbAdmin.getCountries();
        JComboBox<String> countriesCB = new JComboBox<String>();
        
        for (Country country: countries) {
        	countriesCB.addItem(country.getName());
        }
        
		countryLabel.setVisible(true);
		countryLabel.setBounds(xPos[0], yPos[5], 100, 20);
		
		countriesCB.setVisible(true);
		countriesCB.setBounds(xPos[0], yPos[5], 100, 20);

		
        JLabel descriptionLabel = new JLabel("Descripción");
        descriptionLabel.setVisible(true);
        descriptionLabel.setBounds(xPos[0], yPos[6], 100, 20);
        descriptionLabel.setOpaque(true);

		JTextField descriptionField = new JTextField();
		descriptionField.setBounds(xPos[1], yPos[6], 100, 20);
		descriptionField.setColumns(32);

		if (null != travel) {
			descriptionField.setText(travel.getDescription());
		}


        JLabel servNoIncLabel = new JLabel("Servicios no Incl.");
        servNoIncLabel.setVisible(true);
        servNoIncLabel.setBounds(xPos[0], yPos[7], 100, 20);
        servNoIncLabel.setOpaque(true);

		JTextField servNoIncField = new JTextField();
		servNoIncField.setBounds(xPos[1], yPos[7], 100, 20);
		servNoIncField.setColumns(32);
		
		if (null != travel) {
            servNoIncField.setText(travel.getDescServiceNotIncluded());
        }
        
        DBAdmin dbAdmin = this.dbAdmin;
        JButton okButton = new JButton("Confirmar");
        okButton.setBounds(xPos[0] - 10, yPos[8], 100, 20);
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (nameField.getText().length() > 32 || nameField.getText().length() < 1) {
	            	JOptionPane.showMessageDialog(
	            		null,
	            		"El nombre debe tener como máximo 32 caracteres y mínimo 1.",
	            		"Error de nombre",
	            		JOptionPane.ERROR_MESSAGE
	            	);
            	} else if (null == dates[0]) {
            		JOptionPane.showMessageDialog(
	            		null,
	            		"La fecha de inicio no está establecida.",
	            		"Error de fechas",
	            		JOptionPane.ERROR_MESSAGE
	            	);
            	} else if (null == dates[1]) {
            		JOptionPane.showMessageDialog(
	            		null,
	            		"La fecha de fin no está establecida.",
	            		"Error de fechas",
	            		JOptionPane.ERROR_MESSAGE
	            	);
            	} else {
                	TravelType travelType = null;
                	String travelTypeValue = (String)travelTypesCB.getSelectedItem();
                	
                	for (TravelType tt: travelTypes) {
                		if (tt.getDescription().equals(travelTypeValue)) {
                			travelType = tt;
                			break;
                		}
                	}
                	
                	if (null == travel) {
						Travel travel = new Travel();
						travel.setName(nameField.getText());
						travel.setDescription(descriptionField.getText());
						travel.setDescServiceNotIncluded(servNoIncField.getText());
						travel.setTravelDate(new java.sql.Date(dates[0].getTime()));
						travel.setDuration(Integer.valueOf(daysField.getText()));
						travel.setAgency(agency);
						travel.setTravelType(travelType);
						
						dbAdmin.insertTravel(travel);
                	} else {
						travel.setName(nameField.getText());
						travel.setDescription(descriptionField.getText());
						travel.setDescServiceNotIncluded(servNoIncField.getText());
						travel.setTravelDate(new java.sql.Date(dates[0].getTime()));
						travel.setDuration(Integer.valueOf(daysField.getText()));
						travel.setAgency(agency);
						travel.setTravelType(travelType);

                		dbAdmin.updateTravel(travel);
                	}
                	
                	
                	genMenu(agency.getName(), agency.getPassword());
                	changeMenu(3);
            	}
            }
        });

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(xPos[1] + 10, yPos[7], 100, 20);
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	changeMenu(3);
            }
        });
        
        p.add(nameLabel);
        p.add(nameField);
        p.add(travelTypesLabel);
        p.add(travelTypesCB);
        p.add(dateStartLabel);
        p.add(dateEndLabel);
        p.add(datePickerStart);
        p.add(datePickerEnd);
        p.add(daysLabel);
        p.add(daysField);
        p.add(descriptionLabel);
        p.add(descriptionField);
        p.add(servNoIncLabel);
        p.add(servNoIncField);
        p.add(okButton);
        p.add(cancelButton);
    }
    

    private void genMenuEvent(Agency agency, Travel travel, Accommodation accommodation, Flight flight, Other other) {
    	
    	JPanel p = mainMenus.get(5);
        p.removeAll();
        p.revalidate();
        p.setBounds(0, 0, rootWidth, rootHeight);
        p.setLayout(null);
        
        /*
        ArrayList<JPanel> eventPanels = new ArrayList<JPanel>();
        
        for (int i = 0; i < 3; i++) {
        	eventPanels.add(new JPanel());
        }
        */

		JPanel panelEvent = new JPanel();
		panelEvent.setBounds(0, 0, getBounds().width, getBounds().height);
		//panelEvent.setBackground(new Color(255, 0, 0));
		panelEvent.setOpaque(false);
    	
    	JLabel eventTypeLabel = new JLabel("Tipo de evento");
        JComboBox<String> eventsCB = new JComboBox<String>();
        
    	eventTypeLabel.setBounds(150, 130, 100, 20);
        eventTypeLabel.setVisible(true);
        
		eventsCB.addItem("Hotel");
		eventsCB.addItem("Vuelo");
		eventsCB.addItem("Otro");
		eventsCB.setBounds(250, 130, 100, 20);
		eventsCB.setVisible(true);
        eventsCB.setSelectedItem("Hotel");
        
        eventsCB.addItemListener(new ItemListener () {
			@Override
			public void itemStateChanged(ItemEvent event) {
			   if (event.getStateChange() == ItemEvent.SELECTED) {
				  if (eventsCB.getSelectedIndex() == 0) {
					  genMenuAccommodation(agency, travel, panelEvent, null);
				  } else if (eventsCB.getSelectedIndex() == 1) {
					  genMenuFlight(agency, travel, panelEvent, null);
				  } else {
					  // #TODO Revisar toda la funcion 
					  //genMenuOther(agency, travel, panelEvent, null);
				  }
			   }
			}
		});
        
        genMenuAccommodation(agency, travel, panelEvent, null);

		JButton cancelButton = new JButton("Cancelar");
	        cancelButton.setVisible(true);
	        cancelButton.setBounds(435, 375, 100, 20);
	        cancelButton.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	genMenu(agency.getName(), agency.getPassword());
	            	changeMenu(3);
	       	}
        });

    	p.add(eventTypeLabel);
    	p.add(eventsCB);
    	p.add(panelEvent);
    	p.add(cancelButton);
    }
    
    private void genMenuAccommodation(Agency agency, Travel travel, JPanel panel, Accommodation accommodation) {
    	panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);
        
        JLabel     eventNameLabel = new JLabel("Nombre evento:");
    	JTextField eventNameField = new JTextField();
    	
    	eventNameLabel.setBounds(150, 100, 100, 20);
    	eventNameLabel.setVisible(true);

    	eventNameField.setBounds(250, 100, 100, 20);
    	eventNameField.setVisible(true);
    
    	if (null != accommodation) {
    		eventNameField.setText(accommodation.getName());
    	}
    	
    	JLabel              roomTypesLabel = new JLabel("Tipo habitación:");
    	ArrayList<RoomType> roomTypes      = dbAdmin.getRoomTypes();
        JComboBox<String>   roomTypesCB    = new JComboBox<String>();
        
        roomTypesLabel.setBounds(400, 100, 100, 20);
        roomTypesLabel.setVisible(true);

        roomTypesCB.setBounds(500, 100, 150, 20);
        roomTypesCB.setVisible(true);
        
        
        for (RoomType roomType: roomTypes) {
        	roomTypesCB.addItem(roomType.getName());
        }
    	
    	
    	JLabel cityLabel = new JLabel("Ciudad");
    	JComboBox<String> citiesCB = new JComboBox<String>();
    	ArrayList<City> cities = dbAdmin.getCities();
    	
    	for (City city: cities) {
    		citiesCB.addItem(city.getName());
    	}
    	
    	cityLabel.setBounds(400, 130, 100, 20);
    	cityLabel.setVisible(true);
    	
    	citiesCB.setBounds(500, 130, 150, 20);
    	citiesCB.setVisible(true);

		
		JLabel priceLabel = new JLabel("Precio:");
    	JTextField priceField = new JTextField();
    	
    	priceLabel.setBounds(400, 160, 100, 20);
    	priceLabel.setVisible(true);
    	
    	priceField.setBounds(500, 160, 150, 20);
    	priceField.setVisible(true);
    	
    	
    	final Date[] dates = {null, null};

		JLabel dateStartLabel = new JLabel("Fecha inicio:");
		dateStartLabel.setBounds(400, 190, 100, 20);
		
		JDatePickerImpl datePickerStart = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerStart.setBounds(500, 190, 150, 30);
		datePickerStart.addActionListener(e -> {
			GregorianCalendar calendar = (GregorianCalendar) datePickerStart.getModel().getValue();
			if (null != calendar) {
				dates[0] = calendar.getTime();
			} else {
				dates[0] = null;
			}
		});


		JLabel dateEndLabel = new JLabel("Fin viaje:");
		dateEndLabel.setBounds(400, 220, 100, 20);
		
		JDatePickerImpl datePickerEnd = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerEnd.setBounds(500, 220, 150, 30);
		datePickerEnd.addActionListener(e -> {
			GregorianCalendar calendar = (GregorianCalendar) datePickerEnd.getModel().getValue();
			if (null != calendar) {
				dates[1] = calendar.getTime();
			} else {
				dates[1] = null;
			}
		});
		
		JButton searchButton = new JButton("Buscar alojamiento");
    	searchButton.setVisible(true);
    	searchButton.setBounds(400, 250, 250, 20);
    	searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
				if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("https://www.booking.com/"));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
	       	}
        });
    	
    	JButton confirmButton = new JButton("Confirmar");
	        confirmButton.setVisible(true);
	        confirmButton.setBounds(315, 375, 100, 20);
	        confirmButton.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	
	            	if (eventNameField.getText().length() < 1 || eventNameField.getText().length() > 32 ) {
                        JOptionPane.showMessageDialog(
                        	null,
                        	"El nombre debe ser tener una letra como mínimo y 32 como máximo.",
                        	"Nombre erróneo",
                        	JOptionPane.ERROR_MESSAGE
                        );
                    } else if (null == dates[0] || null == dates[1]) {
                        JOptionPane.showMessageDialog(
                        	null,
                        	"Las fechas no están establecidas.",
                        	"Error de fecha",
                        	JOptionPane.ERROR_MESSAGE
                        );
                    } else if (dates[1].getTime() - dates[0].getTime() < 0) {
                        JOptionPane.showMessageDialog(
                        	null,
                        	"La fecha de fin no puede ser anterior a la fecha de inicio.",
                        	"Error de fecha",
                        	JOptionPane.ERROR_MESSAGE
                        );
                    } else if (!guiAssets.isNumeric(priceField.getText())) {
                    	JOptionPane.showMessageDialog(
                        	null,
                        	"El valor del precio no es numérico.",
                        	"Error de precio",
                        	JOptionPane.ERROR_MESSAGE
                        );
                    } else if (Double.valueOf(priceField.getText()) < 0.01) {
                        JOptionPane.showMessageDialog(
                        	null,
                        	"El precio no puede ser 0 o menor.",
                        	"Error de precio",
                        	JOptionPane.ERROR_MESSAGE
                        );
                    } else if (Double.valueOf(priceField.getText()) > 999.99) {
                        JOptionPane.showMessageDialog(
                        	null,
                        	"El precio no puede ser mayor de 999.99 €.",
                        	"Error de precio",
                        	JOptionPane.ERROR_MESSAGE
                        );
                    } else {
                    	System.out.println(dates[0]);
                    	System.out.println(dates[1]);
                    	
                    	Accommodation acc = accommodation;
                    	if (null == acc) {
                    		acc = new Accommodation();
                    	}
                    	
                    	
                    	acc.setName(eventNameField.getText());
						acc.setPrice(Double.valueOf(priceField.getText()));
						acc.setEnterDate(new java.sql.Date(dates[0].getTime()));
						acc.setExitDate(new java.sql.Date(dates[1].getTime()));
						acc.setTravel(travel);
						acc.setCity(cities.get(citiesCB.getSelectedIndex()));
						acc.setRoomType(roomTypes.get(roomTypesCB.getSelectedIndex()));

                    	if (null == accommodation) {
                    		dbAdmin.insertAccommodation(acc);
                    	} else {
                    		dbAdmin.updateAccommodation(acc);
                    	}
                    	
                    	genMenu(agency.getName(), agency.getPassword());
						changeMenu(3);
                    	
                    }
	       	}
        });
    	
    	panel.add(eventNameLabel);
    	panel.add(eventNameField);
    	panel.add(cityLabel);
    	panel.add(citiesCB);
    	panel.add(priceLabel);
    	panel.add(priceField);
    	panel.add(roomTypesLabel);
     	panel.add(roomTypesCB);
     	panel.add(dateStartLabel);
    	panel.add(datePickerStart);
      	panel.add(dateEndLabel);
     	panel.add(datePickerEnd);
     	panel.add(searchButton);
    	panel.add(confirmButton);
    	
    	panel.revalidate();
        panel.repaint();
    }

    private void genMenuFlight(Agency agency, Travel travel, JPanel panel, Flight flight) {
    	panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);

        JLabel     eventNameLabel = new JLabel("Nombre evento:");
    	JTextField eventNameField = new JTextField();
    	
    	eventNameLabel.setBounds(150, 100, 100, 20);
    	eventNameLabel.setVisible(true);

    	eventNameField.setBounds(250, 100, 100, 20);
    	eventNameField.setVisible(true);

		if (null != flight) {
    		eventNameField.setText(flight.getCode());
    	}

		
		ArrayList<Airport> airports = dbAdmin.getAirports();

		JLabel goAirportLabel = new JLabel("Aeropuerto origen:");
		JComboBox<String> goAirportsCB = new JComboBox<String>();
		
		for (Airport airport: airports) {
			goAirportsCB.addItem(airport.getName());
		}
		
		goAirportLabel.setBounds(400, 100, 120, 20);
		goAirportLabel.setVisible(true);
		
		goAirportsCB.setBounds(520, 100, 150, 20);
		goAirportsCB.setVisible(true);
		
		
		
		JLabel returnAirportLabel = new JLabel("Aeropuerto destino:");
		JComboBox<String> returnAirportsCB = new JComboBox<String>();
		
		for (Airport airport: airports) {
			returnAirportsCB.addItem(airport.getName());
		}
		
		returnAirportLabel.setBounds(400, 130, 120, 20);
		returnAirportLabel.setVisible(true);
		
		returnAirportsCB.setBounds(520, 130, 150, 20);
		returnAirportsCB.setVisible(true);
		
	
	
		final Date[] dates = {null};
		
		JLabel dateStartLabel = new JLabel("Fecha ida:");
		dateStartLabel.setBounds(400, 160, 120, 20);
		
		JDatePickerImpl datePickerStart = new JDatePickerImpl(new JDatePanelImpl(null));
		datePickerStart.setBounds(520, 160, 150, 30);
		datePickerStart.addActionListener(e -> {
			GregorianCalendar calendar = (GregorianCalendar) datePickerStart.getModel().getValue();
			if (null != calendar) {
				dates[0] = calendar.getTime();
			} else {
				dates[0] = null;
			}
		});
		
		
		
		JButton searchButton = new JButton("Buscar viaje");
		searchButton.setVisible(true);
		searchButton.setBounds(150, 160, 200, 20);
		searchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
				if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						desktop.browse(new URI("https://www.skyscanner.net/"));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
	       	}
	    });
		
		
		
	    JLabel     flightCodeLabel = new JLabel("Código vuelo:");
		JTextField flightCodeField = new JTextField();
		
		flightCodeLabel.setBounds (400, 210, 120, 20);
		flightCodeLabel.setVisible(true);
	
		flightCodeField.setBounds(520, 210, 150, 20);
		flightCodeField.setVisible(true);
		
		
		ArrayList<Airline> airlines = dbAdmin.getAirlines();
		JLabel     airlineLabel = new JLabel("Aerolínea:");
		JComboBox<String> airlinesCB = new JComboBox<String>();
		
		for (Airline airline: airlines) {
			airlinesCB.addItem(airline.getName());
		}
		
		airlineLabel.setBounds(400, 240, 120, 20);
		airlineLabel.setVisible(true);
		
		airlinesCB.setBounds(520, 240, 150, 20);
		airlinesCB.setVisible(true);
		
		
		JLabel priceLabel = new JLabel("Precio:");
		JTextField priceField = new JTextField();
		
		priceLabel.setBounds(400, 270, 120, 20);
		priceLabel.setVisible(true);
		
		priceField.setBounds(520, 270, 150, 20);
		priceField.setVisible(true);
		

		JLabel departureTimeLabel = new JLabel("Horario Salida:");
		JTextField departureTimeField = new JTextField();
		
		departureTimeLabel.setBounds(400, 300, 120, 20);
		departureTimeLabel.setVisible(true);
		
		departureTimeField.setBounds(520, 300, 150, 20);
		departureTimeField.setVisible(true);
		
		
		
		JLabel durationLabel = new JLabel("Duración:");
		JTextField durationField = new JTextField();
	
		durationLabel.setBounds(400, 330, 120, 20);
		durationLabel.setVisible(true);
		
		durationField.setBounds(520, 330, 150, 20);
		durationField.setVisible(true);
		
		ArrayList<Flight> flights     = dbAdmin.getFlightsByIdTravel(travel);
		JLabel            flightLabel = new JLabel("Vuelo:");
		JComboBox<String> flightsCB   = new JComboBox<String>();
		
		flightsCB.addItem("---");
		
		for (Flight flightt: flights) {
			flightsCB.addItem(flightt.getCode());
		}
		
		
		flightLabel.setBounds(150, 190, 100, 20);
		flightLabel.setVisible(true);
		
		flightsCB.setBounds(200, 190, 150, 20);
		flightsCB.setVisible(true);
		
		JButton confirmButton = new JButton("Confirmar");
	    confirmButton.setVisible(true);
	    confirmButton.setBounds(315, 375, 100, 20);
	    //*
	    confirmButton.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	
	        	if (eventNameField.getText().length() < 1 || eventNameField.getText().length() > 32 ) {
	                JOptionPane.showMessageDialog(
		            	null,
		            	"El nombre debe ser tener una letra como mínimo y 32 como máximo.",
		            	"Nombre erróneo",
		            	JOptionPane.ERROR_MESSAGE
		            );
	            } else if (null == dates[0]) {
	                JOptionPane.showMessageDialog(
	                	null,
	                	"La fecha no está establecida.",
	                	"Error de fecha",
	                	JOptionPane.ERROR_MESSAGE
	                );
	            } else if (!guiAssets.isNumeric(priceField.getText())) {
	            	JOptionPane.showMessageDialog(
	                	null,
	                	"El valor del precio no es numérico.",
	                	"Error de precio",
	                	JOptionPane.ERROR_MESSAGE
	                );
	            } else if (Double.valueOf(priceField.getText()) < 0.01) {
	                JOptionPane.showMessageDialog(
	                	null,
	                	"El precio no puede ser 0 o menor.",
	                	"Error de precio",
	                	JOptionPane.ERROR_MESSAGE
	                );
	            } else if (Double.valueOf(priceField.getText()) > 999.99 ) {
	                JOptionPane.showMessageDialog(
	                	null,
	                	"El precio no puede ser mayor de 999.99 €.",
	                	"Error de precio",
	                	JOptionPane.ERROR_MESSAGE
	                ); 
	            } else if (!guiAssets.isInt(durationField.getText())) {
	            	JOptionPane.showMessageDialog(
	                	null,
	                	"El valor de la duración debe ser un número entero.",
	                	"Error de duración",
	                	JOptionPane.ERROR_MESSAGE
	                ); 
	            } else if (!(new HourAssets()).hourMinuteValid(departureTimeField.getText())) {
	                JOptionPane.showMessageDialog(
	                	null,
	                	"El formato debe ser HH:mm.",
	                	"Error de hora",
	                	JOptionPane.ERROR_MESSAGE
	                );
	            } else {
	            	Flight fl = flight;

	            	if (null == fl) {
	            		fl = new Flight();
	            	}
	            	
	            	
	            	GregorianCalendar calendar = (GregorianCalendar) datePickerStart.getModel().getValue();
	            	Timestamp tt = new Timestamp(
	            		calendar.getTime().getTime() +
	            		(new HourAssets()).hourMinuteToMilisecods(departureTimeField.getText())
	            	);
	            	
	            	
	            	
					fl.setAirportStart(airports.get(goAirportsCB.getSelectedIndex()));
					fl.setAirportEnd(airports.get(returnAirportsCB.getSelectedIndex()));
					fl.setCode(flightCodeField.getText());
					fl.setAirline(airlines.get(airlinesCB.getSelectedIndex()));
					fl.setPrice(Double.valueOf(priceField.getText()));
					fl.setStartMoment(tt);
					fl.setDuration(Integer.valueOf(durationField.getText()));
					fl.setTravel(travel);
					
					if (null == flight) {
						dbAdmin.insertFlight(fl);
					} else {
						// #TODO
						dbAdmin.updateFlight(fl);
					}
					
					/*
					#XXX REVISAR QUE FUNCIONA
					
					Se tiene que insertar el vuelo para establecer el id automático
					y luego consultar a la DB el mismo vuelo para saber el id,
					así se lo podremos asignar al objeto "fl".
					
					getFlightByCode
					*/
					
					fl = dbAdmin.getFlightByCode(fl.getCode());
					;

					if (flightsCB.getSelectedIndex() != 0) {
						FlightPair fp = new FlightPair();
						fp.setGoFlight(flights.get(flightsCB.getSelectedIndex() - 1));
						fp.setReturnFlight(fl);
						fp.setTravel(travel);

						dbAdmin.insertFlightPair(fp);
					}
					
					genMenu(agency.getName(), agency.getPassword());
					changeMenu(3);
	            }
			}
        });
	    //*/
		
		panel.add(eventNameLabel);
		panel.add(eventNameField);
		panel.add(goAirportLabel);
		panel.add(goAirportsCB);
		panel.add(returnAirportLabel);
		panel.add(returnAirportsCB);
		panel.add(dateStartLabel);
		panel.add(datePickerStart);
		panel.add(searchButton);
		panel.add(flightCodeLabel);
		panel.add(flightCodeField);
		panel.add(airlineLabel);
		panel.add(airlinesCB);
		panel.add(priceLabel);
		panel.add(priceField);
		panel.add(departureTimeLabel);
		panel.add(departureTimeField);
		panel.add(durationLabel);
		panel.add(durationField);
		panel.add(confirmButton);
		panel.add(flightLabel);
		panel.add(flightsCB);
		
        panel.revalidate();
        panel.repaint();
	}

 
    private void genMenuOther(Agency agency, Travel travel, JPanel panel, Other other) {
    	panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setLayout(null);

        
        JLabel     eventNameLabel = new JLabel("Nombre evento:");
    	JTextField eventNameField = new JTextField();
    	
    	eventNameLabel.setBounds(150, 100, 100, 20);
    	eventNameLabel.setVisible(true);

    	eventNameField.setBounds(250, 100, 100, 20);
    	eventNameField.setVisible(true);

    	if (null != other) {
    		eventNameField.setText(other.getName());
    	}

    	
    	
        JLabel    descriptionLabel = new JLabel("Descripción:");
    	JTextArea descriptionArea= new JTextArea();
    	
    	descriptionLabel.setBounds(0, 0, 0, 0);
    	descriptionLabel.setVisible(true);

    	descriptionArea.setBounds(0, 0, 0, 0);
    	descriptionArea.setVisible(true);
    	
    	
    	
		final Date[] dates = {null};
		
		JLabel dateLabel = new JLabel("Fecha:");
		dateLabel.setBounds(0, 0, 0, 0);
		
		JDatePickerImpl datePicker = new JDatePickerImpl(new JDatePanelImpl(null));
		datePicker.setBounds(0, 0, 0, 0);
		datePicker.addActionListener(e -> {
			GregorianCalendar calendar = (GregorianCalendar) datePicker.getModel().getValue();
			if (null != calendar) {
				dates[0] = calendar.getTime();
			} else {
				dates[0] = null;
			}
		});
    	
		
		
		JLabel priceLabel = new JLabel("Precio:");
		JTextField priceField = new JTextField();
		
		priceLabel.setBounds(0, 0, 0, 0);
		priceLabel.setVisible(true);
		
		priceField.setBounds(0, 0, 0, 0);
		priceField.setVisible(true);
		
		
		
		JButton confirmButton = new JButton("Confirmar");
	    confirmButton.setVisible(true);
	    confirmButton.setBounds(315, 375, 100, 20);
	    confirmButton.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	
	        	if (eventNameField.getText().length() < 1 || eventNameField.getText().length() > 32 ) {
	                JOptionPane.showMessageDialog(
		            	null,
		            	"El nombre debe ser tener una letra como mínimo y 32 como máximo.",
		            	"Nombre erróneo",
		            	JOptionPane.ERROR_MESSAGE
		            );
	            } else if (null == dates[0]) {
	                JOptionPane.showMessageDialog(
	                	null,
	                	"La fecha no está establecida.",
	                	"Error de fecha",
	                	JOptionPane.ERROR_MESSAGE
	                );
	            } else if (!guiAssets.isNumeric(priceField.getText())) {
	            	JOptionPane.showMessageDialog(
	                	null,
	                	"El valor del precio no es numérico.",
	                	"Error de precio",
	                	JOptionPane.ERROR_MESSAGE
	                );
	            } else if (Double.valueOf(priceField.getText()) < 0.01) {
	                JOptionPane.showMessageDialog(
	                	null,
	                	"El precio no puede ser 0 o menor.",
	                	"Error de precio",
	                	JOptionPane.ERROR_MESSAGE
	                );
	            } else if (Double.valueOf(priceField.getText()) > 999.99) {
	                JOptionPane.showMessageDialog(
	                	null,
	                	"El precio no puede ser mayor de 999.99€.",
	                	"Error de precio",
	                	JOptionPane.ERROR_MESSAGE
	                );
	            } else {
	            	Other ot = other;
	            	if (null == ot) {
	            		ot = new Other();
	            	}
	            	
	            	
	            	ot.setName(eventNameField.getText());
	            	ot.setDescription(descriptionArea.getText());
	            	ot.setEventDate(new java.sql.Date(dates[0].getTime()));
	            	ot.setPrice(Double.valueOf(priceField.getText()));
	            	ot.setTravel(travel);
	
	            	if (null == other) {
                        // #XXX Si falla son las comillas del formato
	            		//dbAdmin.insertOther(other);
	            	} else {
	            		//dbAdmin.updateOther(other);
					}
					
					genMenu(agency.getName(), agency.getPassword());
					changeMenu(3);
	            }
			}
        });
		
    	panel.add(eventNameLabel);
    	panel.add(eventNameField);
    	panel.add(descriptionLabel);
    	panel.add(descriptionArea);
    	panel.add(dateLabel);
    	panel.add(datePicker);
    	panel.add(priceLabel);
    	panel.add(confirmButton);

        panel.revalidate();
        panel.repaint();
    }
	
    
    private void changeMenu(int index) {
    	this.guiAssets.selectPanel(mainMenus, index);
    }
    
    private void changeSubMenu(int index) {
		this.guiAssets.selectPanel(mainMenus, index);        
    }
       
 }
