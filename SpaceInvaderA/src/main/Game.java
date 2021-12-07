package main;

import java.util.ArrayList;
import model.SpaceInvader;
import model.SpacePlayer;
import utilitaires.Utilitaires;

public class Game {

	char [][] map = new char [20][20];
	ArrayList<SpaceInvader> listSI = new ArrayList<SpaceInvader>();
	ArrayList<Shoot> listShoot = new ArrayList<Shoot>();
	
	SpacePlayer p1;
	int compteurForSI = 0;
	
	public void launchGame() {
		
			Utilitaires.fillMap(map);
			createAndPlaceSIOnMap();
			createAndPlacePlayerOnMap();
		do {
			Utilitaires.readMap(map);
			fireAndMoveShoot();
			movePlayerOnMap();
			moveSIOnMap();
		}
		while(checkGameOver());
	}


	private boolean checkGameOver() {
		for (SpaceInvader spaceInvader : listSI) {
			if(spaceInvader.getY()>=17) {
				return false;
			}
		}
		return true;
	}

	private void fireAndMoveShoot() {			
		listShoot.add(new Shoot('|', p1.getX(), p1.getY()-1));

		Shoot shootToRemove = null;
		for (Shoot s : listShoot) {
			if(map[s.getX()][s.getY()-1] != '0') {
				map[s.getX()][s.getY()] = ' ';
				s.setY(s.getY()-1);
				map[s.getX()][s.getY()] = s.getName();
			}
			else {
				shootToRemove = s;
			}
		}
		if(shootToRemove!=null) {
			map[shootToRemove.getX()][shootToRemove.getY()] = ' ';
			listShoot.remove(shootToRemove);
		}
	}


	private void moveSIOnMap() {
		switch (compteurForSI) {
		case 0:
			for(SpaceInvader si : listSI) {
				map[si.getX()][si.getY()] = ' ';
				si.setX(si.getX()-1);
				map[si.getX()][si.getY()] = si.getName();
			}
			compteurForSI++;
			break;
		case 1 :
			for(SpaceInvader si : listSI) {
				map[si.getX()][si.getY()] = ' ';
				si.setX(si.getX()+1);
				map[si.getX()][si.getY()] = si.getName();
			}
			compteurForSI++;
			break;
		case 2 :
			for(SpaceInvader si : listSI) {
				map[si.getX()][si.getY()] = ' ';
				si.setY(si.getY()+1);
				map[si.getX()][si.getY()] = si.getName();
			}
			compteurForSI=0;
			break;
		}
		
	}


	private void movePlayerOnMap() {

		
		switch(Utilitaires.saisieString()) {
			case("a"): 
				if(map[p1.getX()-1][p1.getY()] != '0'){
					map[p1.getX()][p1.getY()] = ' ';
					p1.setX(p1.getX()-1);				
					map[p1.getX()][p1.getY()] = p1.getName();
				}
				break;
			case("z"): 
				if(map[p1.getX()+1][p1.getY()] != '0'){
					map[p1.getX()][p1.getY()] = ' ';
					p1.setX(p1.getX()+1);				
					map[p1.getX()][p1.getY()] = p1.getName();
				}
				break;
			default:;
		}
	}


	private void createAndPlacePlayerOnMap() {
		p1 = new SpacePlayer('W', 9, 17);
		map[p1.getX()][p1.getY()] = p1.getName();
	}


	private void createAndPlaceSIOnMap() {
		for(int j = 3; j < 10 ; j = j + 2) {
			for(int i = 3; i<map.length -2; i = i +2) {
				//SpaceInvader sp1 = new SpaceInvader('S', i, j);
				//listSI.add(sp1);
				listSI.add(new SpaceInvader('S', i, j));	
			}
		}
		for (SpaceInvader sp : listSI) {
			map[sp.getX()][sp.getY()] = sp.getName();

		}
		
	}

}
