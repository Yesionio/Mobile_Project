#!/usr/bin/env pypy3

import os

# curfiles = [x for x in os.listdir() if x.split('.')[-1] in ['jsp']] 
# for x in curfiles:
#     y = x[:x.find('.')] + '.html'
#     print(x, 'Change to', y)
#     flag = os.rename(x, y)

if __name__ == '__main__':
    chfiles = [x for x in os.listdir() if x.split('.')[-1] in ['html', 'css']]
    s = "iconv -f GB2312 -t UTF-8 {} -o {}"
    for x in chfiles:
        print('正在转换文件', x, end='            ')
        os.system(s.format(x, x))
        print('转换成功')

