# svg2vector

_批量转换svg文件为Android可用的xml_

---
## Feature

- [x] 将图形都转换成Path(rect,circle,line,path,ellipse,polyline,polygon)
- [x] Android支持的属性(width,height,viewportWidth,viewportHeight,fillAlpha,fillColor,fillType,pathData,strokeWidth,strokeColor)
- [x] 无Transform的svg已可用

## TODO
- [ ] 支持所有Transform(matrix,translate,rotate,scale,skew,skewx,skewy,transform)
    - [ ] 用Group实现
    - [ ] 直接修改坐标实现
