package General;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class The_Skyline_Problem {

    class Tower {
        int x;
        int y;
        boolean start;

        public Tower(int x, int y, boolean start) {
            this.x = x;
            this.y = y;
            this.start = start;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new LinkedList<>();
        Tower[] towers = new Tower[buildings.length * 2];
        int index = 0;
        for (int[] building : buildings) {
            Tower tower = new Tower(building[0], building[2], true);
            towers[index] = tower;
            index++;
            Tower tower2 = new Tower(building[1], building[2], false);
            towers[index] = tower2;
            index++;
        }
        Arrays.sort(towers, new Comparator<Tower>() {

            @Override
            public int compare(Tower tower1, Tower tower2) {
                if (tower1.x != tower2.x) {
                    return tower1.x - tower2.x;
                } else {
                    if (tower1.start && tower2.start) {
                        return tower2.y - tower1.y;
                    }
                    if (!tower1.start && !tower2.start) {
                        return tower1.y - tower2.y;
                    }
                    if (tower1.start) {
                        return -tower1.y;
                    }
                    return -tower2.y;
                }
            }
        });
        for (Tower tower : towers) {
            System.out.println(tower.x + "," + tower.y + "," + tower.start);
        }

        // TreeMap: stores elements in sorted order (increasing)
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int max = 0;
        map.put(0, 1);
        for (Tower tower : towers) {
            // push height on to map
            if (tower.start) {
                map.computeIfPresent(tower.y, (key, val) -> val + 1);
                map.putIfAbsent(tower.y, 1);

            }
            // boolean value false pop the respective height
            else {
                int val = map.get(tower.y);
                val--;
                if (val == 0) {
                    map.remove(tower.y);
                } else
                    map.put(tower.y, val);
            }

            // update max if new entry is greater than current max
            // and add the coordinates to result when ever max changes
            if (max != map.lastKey()) {
                max = map.lastKey();
                List<Integer> list = new LinkedList<>();
                list.add(tower.x);
                list.add(max);
                result.add(list);
            }
        }

        return result;
    }

    // Tushar
    static class BuildingPoint implements Comparable<BuildingPoint> {
        int x;
        boolean isStart;
        int height;

        @Override
        public int compareTo(BuildingPoint o) {
            // first compare by x.
            // If they are same then use this logic
            // if two starts are compared then higher height building should be picked first
            // if two ends are compared then lower height building should be picked first
            // if one start and end is compared then start should appear before end
            if (this.x != o.x) {
                return this.x - o.x;
            } else {
                return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
            }
        }
    }

    public List<List<Integer>> getSkylineTushar(int[][] buildings) {

        // for all start and end of building put them into List of BuildingPoint
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        int index = 0;
        for (int building[] : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];

            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].x = building[1];
            buildingPoints[index + 1].isStart = false;
            buildingPoints[index + 1].height = building[2];
            index += 2;
        }
        Arrays.sort(buildingPoints);
        for (BuildingPoint buildingPoint : buildingPoints) {
            System.out.println(buildingPoint.x + "," + buildingPoint.height + "," + buildingPoint.isStart);
        }
        return null;
    }

    public static void main(String[] args) {
        The_Skyline_Problem obj = new The_Skyline_Problem();
        int[][] buildings = { { 0, 2, 3 }, { 2, 5, 3 } };
        List<List<Integer>> result = obj.getSkyline(buildings);
        System.out.println(result);
        // System.out.println("Tushar");
        // obj.getSkylineTushar(buildings);
    }

}
