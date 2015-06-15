package ui.frame.team;

import java.awt.Color;

import javax.swing.JPanel;

import ui.system.UIData;

@SuppressWarnings("serial")
public class OldSingleTeamPanel extends JPanel{
	OldTeamPicPanel[] picPanel = new OldTeamPicPanel[5];
	
	int width = (int) (600 * UIData.changeX);
	int height = (int) (144 * UIData.changeY);
	
	public OldSingleTeamPanel(int division){
		this.setVisible(true);
		//this.setOpaque(false);
		this.setLayout(null);
		this.setBackground(new Color(0.7f, 0.7f, 0.7f, 0.05f));
		
		int step = width / 5;
		
		for(int i = 0; i < 5; i++){
			picPanel[i] = new OldTeamPicPanel(step * i, 0, step, (int) (120 * UIData.changeY), getTeamName(division, i));
			this.add(picPanel[i]);
		}
		
//		JLabel divisionName = new JLabel(getDivisionName(division) + "  ", JLabel.RIGHT);
//		divisionName.setVisible(true);
//		divisionName.setForeground(Color.ORANGE);
//		divisionName.setFont(new Font("新細明體", Font.BOLD, (int)(30 * UIData.changeY)));
//		divisionName.setBounds(0, (int) ((260 - 38) * UIData.changeY), width, (int) (30 * UIData.changeY));
//		this.add(divisionName);
	}
	
		
	//太平洋区 西南区 西北区
	//大西洋区 东南区 中部区
	
	private String getTeamName(int division, int i){
		
		int key = division * 5 + 1 + i;
		
		switch(key){
		case 1:
			return "TRI";
		case 2:
			return "DNR";
		case 3:
			return "DNN";
		case 4:
			return "DNA";
		case 5:
			return "HSM";
		
		case 6:
			return "FLO";
		case 7:
			return "CLR";
		case 8:
			return "PTC";
		case 9:
			return "PIT";
		case 10:
			return "PTP";
			
		case 11:
			return "WSB";
		case 12:
			return "WSC";
		case 13:
			return "WSA";
		case 14:
			return "CAR";
		case 15:
			return "INJ";
		
		case 16:
			return "INO";
		case 17:
			return "INA";
		case 18:
			return "SDC";
		case 19:
			return "SDR";
		case 20:
			return "SDS";
			
		case 21:
			return "SAA";
		case 22:
			return "SSL";
		case 23:
			return "STL";
		case 24:
			return "STB";
		case 25:
			return "SDA";
		
		case 26:
			return "KCO";
		case 27:
			return "KCK";
		case 28:
			return "TRH";
		case 29:
			return "OAK";
		case 30:
			return "MMT";
			
		case 31:
			return "MMP";
		case 32:
			return "MMS";
		case 33:
			return "AND";
		case 34:
			return "MLH";
		case 35:
			return "BLB";
		
		case 36:
			return "BAL";
		case 37:
			return "BUF";
		case 38:
			return "DTF";
		case 39:
			return "TEX";
		case 40:
			return "NOB";
			
		case 41:
			return "NOJ";
		case 42:
			return "NJN";
		case 43:
			return "NJA";
		case 44:
			return "SFW";
		case 45:
			return "MNP";
		
		case 46:
			return "MNM";
		case 47:
			return "MNL";
		case 48:
			return "PRO";
		case 49:
			return "LAS";
		case 50:
			return "VAN";
			
		case 51:
			return "WAT";
		case 52:
			return "UTS";
		case 53:
			return "FTW";
		case 54:
			return "NYN";
		case 55:
			return "NYA";
		
		case 56:
			return "VIR";
		case 57:
			return "ROC";
		case 58:
			return "KEN";
		case 59:
			return "CHP";
		case 60:
			return "CHZ";
			
		case 61:
			return "CHS";
		case 62:
			return "SHE";
		case 63:
			return "SYR";
		case 64:
			return "SEA";
		case 65:
			return "PHW";
		
		case 66:
			return "CIN";
		case 67:
			return "DLC";
		case 68:
			return "MMF";
		case 69:
			return "ANA";
		case 70:
			return "CAP";
		}
		
		return null;
	}
	
}
