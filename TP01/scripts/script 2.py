#!/usr/bin/python
import re

def main():
  positions = []
  items = []
  posDict = {}
  dict = {'D':'TileKind.Dot', 'B':'TileKind.Bamboo', 'C':'TileKind.Character', 'W':'TileKind.Wind', 'R':'TileKind.Dragon', 'S':'TileKind.Season', 'F':'TileKind.Flower'}
  dict2 = {"BALL_":"TileKind.Dot", "BAMBOO_":"TileKind.Bamboo", "CHARACTER_":"TileKind.Character", "DRAGON_":"TileKind.Dragon", "FLOWER_":"TileKind.Flower", "SEASON_":"TileKind.Season", "WIND_":"TileKind.Wind"}
  f = open('Rat.layout')

  s = ''
  for line in f:
    s += line.replace('\n', '')

  p = re.compile('layout.position.x.(\d+)=(\d+)layout.position.y.\d+=(\d+)layout.position.z.\d+=(\d+)')
  for m in p.finditer(s):
    sentence = "positions.add(new Position(%s, %s, %s));\n" % (m.group(4), m.group(2), m.group(3))
    positions.append(sentence)
    posDict[m.group(1)] = [m.group(4), m.group(2), m.group(3)]

  p = re.compile('tile.value.(\d+)=(\w+_)(\d+)')
  for m in p.finditer(s):
    item = "board.setItem(new Position(%s, %s, %s), new Tile(%s, %s));\n" % (posDict[m.group(1)][0], posDict[m.group(1)][1], posDict[m.group(1)][2], dict2[m.group(2)], m.group(3))
    items.append(item)

  for position in positions:
    print position

  for item in items:
  	print item

if __name__ == '__main__':
  main()