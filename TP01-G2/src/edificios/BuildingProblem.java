package edificios;

import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;
import heuristics.Heuristic;

import java.util.LinkedList;
import java.util.List;

import util.Logger;

public class BuildingProblem implements GPSProblem {

	protected Board initBoard;
	protected List<GPSRule> rules;
	protected Heuristic heuristic;
	
	public BuildingProblem(Board board) {
		initBoard = board;
		rules = new LinkedList<GPSRule>();
		initializeRules();
//		sortRules();
	}
	
	protected void initializeRules() {
		int maxHeight = initBoard.getSize();
		for (int i = 0; i < maxHeight; i++) {
			for (int j = 0; j < maxHeight; j++) {
				for (int k = 1; k <= maxHeight; k++) {
					rules.add(new BuildingRule(i,j,k));
				}
			}
		}
	}

	protected void sortRules() {
		sortTop();
		sortBottom();
		sortLeft();
		sortRight();
	}
	
	private void sortTop() {
		int topHeigth = initBoard.getSize();
		int[] topRules = Settings.restrictions[Settings.TOP];
		for (int i = 0; i < topRules.length; i++) {
			if (topRules[i] == 1) {
				setRuleFirst(0, i, topHeigth);
			} else if (topRules[i] == topHeigth) {
				for (int j = 0; j < topHeigth; j++) {
					setRuleFirst(j, i, j + 1);
				}
			}
		}
	}
	
	private void sortBottom() {
		int topHeigth = initBoard.getSize();
		int[] bottomRules = Settings.restrictions[Settings.BOTTOM];
		for (int i = 0; i < bottomRules.length; i++) {
			if (bottomRules[i] == 1) {
				setRuleFirst(topHeigth - 1, i, topHeigth);
			} else if (bottomRules[i] == topHeigth) {
				for (int j = topHeigth; j > 0; j--) {
					setRuleFirst(j - 1, i, topHeigth - j + 1);
				}
			}
		}
	}
	
	private void sortLeft() {
		int topHeigth = initBoard.getSize();
		int[] leftRules = Settings.restrictions[Settings.LEFT];
		for (int i = 0; i < leftRules.length; i++) {
			if (leftRules[i] == 1) {
				setRuleFirst(i, 0, topHeigth);
			} else if (leftRules[i] == topHeigth) {
				for (int j = 0; j < topHeigth; j++) {
					setRuleFirst(i, j, j + 1);
				}
			}
		}
	}

	private void sortRight() {
		int topHeigth = initBoard.getSize();
		int[] rightRules = Settings.restrictions[Settings.RIGHT];
		for (int i = 0; i < rightRules.length; i++) {
			if (rightRules[i] == 1) {
				setRuleFirst(i, topHeigth - 1, topHeigth);
			} else if (rightRules[i] == topHeigth) {
				for (int j = topHeigth; j > 0; j--) {
					setRuleFirst(i, j - 1, topHeigth - j + 1);
				}
			}
		}
	}

	private void setRuleFirst(int row, int col, int height) {
		int index = 0;
		for (GPSRule r: rules) {
			BuildingRule br = (BuildingRule) r;
			if (br.getRow() == row && br.getCol() == col && 
				br.getHeight() == height) {
				break;
			}
			index++;
		}
		if (index == rules.size()) {
			String warning = "Rule: [" + row + ", " + col + "] value: " + height + " not founds!"; 
			Logger.log("Warning", warning, Logger.LEVEL_WARNING);
			return;
		}
		GPSRule r = rules.remove(index);
		((LinkedList<GPSRule>) rules).addFirst(r);
	}
	
	@Override
	public GPSState getGoalState() {
		throw new IllegalStateException();
	}

	@Override
	public Integer getHValue(GPSState state) {
		throw new IllegalStateException();
	}

	@Override
	public GPSState getInitState() {
		return new BuildingState(initBoard);
	}

	@Override
	public List<GPSRule> getRules() {
		return rules;
	}
	
	public void invertRules() {
		List<GPSRule> inverted = new LinkedList<GPSRule>();
		for(GPSRule r: rules) {
			inverted.add(r);
		}
		rules = inverted;
	}
	
	@Override
	public String toString() {
		return "\n" + initBoard.toString();
	}

	public void setHeuristic(Heuristic heuristic) {
		this.heuristic = heuristic;
	}
	
}
