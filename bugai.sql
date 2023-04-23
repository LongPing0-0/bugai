/*
 Navicat Premium Data Transfer

 Source Server         : bugaiMysql
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : 43.142.110.71:3306
 Source Schema         : bugai

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 23/04/2023 23:31:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_download_count
-- ----------------------------
DROP TABLE IF EXISTS `app_download_count`;
CREATE TABLE `app_download_count`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of app_download_count
-- ----------------------------
INSERT INTO `app_download_count` VALUES (1, 24);

-- ----------------------------
-- Table structure for appupdate
-- ----------------------------
DROP TABLE IF EXISTS `appupdate`;
CREATE TABLE `appupdate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `versionCode` int(50) NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(2) NOT NULL DEFAULT 0,
  `created` timestamp NULL DEFAULT NULL,
  `version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of appupdate
-- ----------------------------
INSERT INTO `appupdate` VALUES (1, 202, 'https://bugai-1301015974.cos.ap-chengdu.myqcloud.com/__UNI__1D0593F__20230411230732.apk', '更新弹窗过小bug', 0, '2023-04-08 17:38:12', '2.0.2');
INSERT INTO `appupdate` VALUES (2, 203, 'https://bugai-1301015974.cos.ap-chengdu.myqcloud.com/__UNI__1D0593F__20230411230732.apk', '1.新增了app在线更新和网页更新功能。2.新增交流论坛功能。', 0, '2023-04-09 14:49:27', '2.0.3');
INSERT INTO `appupdate` VALUES (3, 204, 'https://bugai-1301015974.cos.ap-chengdu.myqcloud.com/__UNI__1D0593F__20230412003105.apk', '1.修复了登录不存在用户时提示尚未登录的bug。2.对交流论坛发布信息做了限制，在网卡时做了限制发布重复内容功能', 0, '2023-04-11 20:26:53', '2.0.4');
INSERT INTO `appupdate` VALUES (4, 205, 'https://bugai-1301015974.cos.ap-chengdu.myqcloud.com/__UNI__1D0593F__20230413153053.apk', '1.修改了交流文坛查看详细内容时一直显示第五条信息内容的bug。2.更改了概率论实验四页面。3.我的主页页面里的新增关于页面功能。', 0, '2023-04-12 15:30:42', '2.0.5');
INSERT INTO `appupdate` VALUES (5, 206, 'https://bugai-1301015974.cos.ap-chengdu.myqcloud.com/__UNI__1D0593F__20230415010615.apk', '1.更改了浦丰实验内容、点估计实验内容。2.新增了泊松分布、生日问题实验。3.新增更新日志静态页面（下个 版本数据来源换为后台）', 0, '2023-04-14 12:52:33', '2.0.6');
INSERT INTO `appupdate` VALUES (6, 207, 'https://bugai-1301015974.cos.ap-chengdu.myqcloud.com/__UNI__1D0593F__20230415214214.apk', '1.新增我的主页中，我的动态功能，该功能可以查看自己在交流论坛发布的动态信息。2.更新日志数据来源切换为后台。3.调整浦丰实验内容和泊松分布实验内容布局。4.新增我的界面欢迎小窗口欢迎提示框。5.注册页面对用户名输入进行了限制，更改为只能输入字母加数字格式，原非法账号已经被停用。6.新增帮助文档管理员界面，管理员可在帮助文档里新增帮助文档内容和删除帮助文档内容。7.对注册页账户和密码长度进行了限制。8.交流论坛新增管理员禁言用户功能。9.对绑定邮箱功能进行了限制，绑定过后就不会再出现绑定邮箱功能。', 0, '2023-04-15 02:42:17', '2.0.7');
INSERT INTO `appupdate` VALUES (7, 208, 'https://bugai-1301015974.cos.ap-chengdu.myqcloud.com/__UNI__1D0593F__20230416023722.apk', '新增头像功能，用户绑定qq邮箱后，后台将自动获取用户qq头像，用户无需再上传头像。', 0, '2023-04-16 02:36:55', '2.0.8');
INSERT INTO `appupdate` VALUES (8, 209, 'https://bugai-1301015974.cos.ap-chengdu.myqcloud.com/__UNI__1D0593F__20230417141931.apk', '去点我的页面中欢迎提示窗口，我的动态里头像更换为用户个人头像', 0, '2023-04-17 14:18:02', '2.0.9');
INSERT INTO `appupdate` VALUES (9, 210, 'https://bugai-1301015974.cos.ap-chengdu.myqcloud.com/__UNI__1D0593F__20230418174242.apk', '修改关于页面部分文案', 0, '2023-04-18 17:48:52', '2.1.0');
INSERT INTO `appupdate` VALUES (10, 211, 'https://bugai-1301015974.cos.ap-chengdu.myqcloud.com/__UNI__1D0593F__20230420180149.apk', '修改浦丰实验文案内容', 1, '2023-04-20 18:00:52', '2.1.1');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `classNumber` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `className`(`className`) USING BTREE,
  UNIQUE INDEX `classNumber`(`classNumber`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '一班', '1122');
INSERT INTO `class` VALUES (2, '测试班级2', '1123');

-- ----------------------------
-- Table structure for communication
-- ----------------------------
DROP TABLE IF EXISTS `communication`;
CREATE TABLE `communication`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `content` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) UNSIGNED NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of communication
-- ----------------------------
INSERT INTO `communication` VALUES (4, 22, '3', '2023-04-10 02:41:26', 1);
INSERT INTO `communication` VALUES (5, 22, '5', '2023-04-10 02:41:34', 1);
INSERT INTO `communication` VALUES (6, 22, '6', '2023-04-10 02:41:41', 1);
INSERT INTO `communication` VALUES (7, 22, '7', '2023-04-10 02:41:46', 1);
INSERT INTO `communication` VALUES (8, 22, '8', '2023-04-10 02:41:56', 1);
INSERT INTO `communication` VALUES (9, 22, '9', '2023-04-10 02:42:01', 1);
INSERT INTO `communication` VALUES (10, 22, '10', '2023-04-10 02:42:09', 1);
INSERT INTO `communication` VALUES (13, 23, '<p>111</p>', '2023-04-11 23:43:31', 1);
INSERT INTO `communication` VALUES (14, 22, '<p>safasfasfasf</p>', '2023-04-11 23:59:00', 1);
INSERT INTO `communication` VALUES (15, 22, '<p>fsafasfasfafa</p>', '2023-04-12 00:02:30', 1);
INSERT INTO `communication` VALUES (16, 22, '<p>asfa</p>', '2023-04-12 00:02:35', 1);
INSERT INTO `communication` VALUES (17, 24, '<p>b</p>', '2023-04-12 00:24:23', 1);
INSERT INTO `communication` VALUES (19, 32, '<p>测试</p>', '2023-04-16 01:51:25', 1);

-- ----------------------------
-- Table structure for communication_comment
-- ----------------------------
DROP TABLE IF EXISTS `communication_comment`;
CREATE TABLE `communication_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `cmid` int(11) NOT NULL,
  `commentTime` datetime NULL DEFAULT NULL,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of communication_comment
-- ----------------------------
INSERT INTO `communication_comment` VALUES (20, 22, 5, '2023-04-13 14:56:13', '测试评论');
INSERT INTO `communication_comment` VALUES (21, 22, 17, '2023-04-13 14:57:21', '测试评论');
INSERT INTO `communication_comment` VALUES (22, 32, 19, '2023-04-16 02:05:37', '测试');
INSERT INTO `communication_comment` VALUES (23, 22, 19, '2023-04-16 02:27:50', '测试评论');

-- ----------------------------
-- Table structure for communication_favor
-- ----------------------------
DROP TABLE IF EXISTS `communication_favor`;
CREATE TABLE `communication_favor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cmid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `favorTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `cmid`(`cmid`, `uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of communication_favor
-- ----------------------------
INSERT INTO `communication_favor` VALUES (15, 10, 22, '2023-04-11 14:59:53');
INSERT INTO `communication_favor` VALUES (18, 5, 22, '2023-04-11 23:03:04');
INSERT INTO `communication_favor` VALUES (20, 17, 22, '2023-04-15 22:29:10');
INSERT INTO `communication_favor` VALUES (23, 13, 32, '2023-04-16 10:00:14');
INSERT INTO `communication_favor` VALUES (24, 19, 32, '2023-04-16 10:00:20');
INSERT INTO `communication_favor` VALUES (26, 4, 22, '2023-04-20 18:10:03');

-- ----------------------------
-- Table structure for danxuan
-- ----------------------------
DROP TABLE IF EXISTS `danxuan`;
CREATE TABLE `danxuan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` int(5) UNSIGNED NOT NULL DEFAULT 2,
  `answer` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `explain` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of danxuan
-- ----------------------------
INSERT INTO `danxuan` VALUES (1, '甲、乙两人向同一目标独立地各射击一次,命中率分别为0.8，0. 5,则目标被击中的概率为', 2, 'D', '设事件A为“甲射中目标”，事件B为“乙射 中目标”，事件C为“目标被射中”.当事件C发生 时，甲、乙至少有一人射中目标,根据题意，则有 P(C) = P(AB) +P() +P() =0. 8 X 0. 5 +0. 2 X 0. 5 + 0. 8 X 0. 5 = 0. 9. 或 P(C) = 1-P(() = 1-(1-0. 8) (1-0. 5) =1 -0. 2 X 0. 5 = 0. 9. 故选D.');
INSERT INTO `danxuan` VALUES (2, '设A,B,C三个事件两两独立，则A,B,C相互独立的充分必要条件是 ( )', 2, 'A', '由A,B,C相互独立可知 P(AB) = P(A)P(B)——①， P(AC) = P(A)P(C), P(BC) = P(B)P(C), P(ABC) = P(A)P(B)P(C)—— ② 由①②可得P(ABC)=P(A)P(BC),即A与BC 独立. 故选A.');
INSERT INTO `danxuan` VALUES (3, '当事件A与B同时发生时，事件C必发生，则下列结论中，正确的是 ( )', 2, 'C', '因为事件A与B同时发生时，事件C必发生 就意味着AB 含于C,因此P(C) >= P(AB). 又由 P(A U B) = P(A) +P(B) — P(AB), 所以 P(C) >= P(A) +P(B) — P(A U B) >=P(A)+P(B)-1 故选C.');
INSERT INTO `danxuan` VALUES (4, '将两封信随机地投入4个邮箱中,则未向前两个邮箱中投信的概率为 ( )', 2, 'A', '投每一封信都有4种可能，则两封信投送共 有4^2种情形. 如果只向后两个邮箱中投送，那么两封信共有2^2种情形. 由古典概型概率公式，所求概率为2^2/4^2 . 故选A. ');
INSERT INTO `danxuan` VALUES (5, '设A，B为两个随机事件，且P(AB)>0,则P(A|AB)等于 ( )', 2, 'D', 'P(A|AB)=P[A(AB)]/P(AB)=P(AB)/P(AB)=1');
INSERT INTO `danxuan` VALUES (6, '设随机变量X~b( 4，0.2 )，则P{X>3}等于( )', 2, 'A', '因为X〜b(4，0. 2),则 P{X=k}=C(k，4)(0.2^k)[0.8^(4-k)]，k = 0,1,…,4, 故 P{X > 3} = P{X = 4} = 0.2^4= 0. 001 6. 故选A. ');
INSERT INTO `danxuan` VALUES (7, '设随机变量X的分布函数为F(x),下列结论中，不一定成立的是 ( )', 2, 'D', '对于分布函数F(x)而言，选项A,B,C为基本性质，一定成立.当X为连续型变量时,F(x)为连续函数;当X为离散型变量时,F(x)为非连续函数,则选项D未必成立. 故选D.');
INSERT INTO `danxuan` VALUES (8, '设F1(x),F2(x)为两个分布函数,其相应的概率密度为f1(x) ，f2 (x)是连续函数,则下列必为概率密度的是 ( )', 2, 'D', '根据概率密度的性质，检验各选项，可得f1(x)F2(x)+f2(x)F1(x)>=0，\r\n∫’从-∞到+∞’[f1(x)F2(x)+f2(x)F1(x)]dx = ∫’从-∞到+∞’[F1’(x)F2(x)+F’(2)F1(x)]dx = F1(x)F2(x)I’从-∞到+∞’ = 1。\r\n则选项D满足概率密度的两条性质. 故选D');
INSERT INTO `danxuan` VALUES (9, '已知随机变量X的概率密度为fx(x)，则Y=-2X的概率密度fy(y)为 ( )', 2, 'D', 'y =-2x的反函数为x=-y/2，dx/dy=-1/2. 根据丫 = g(X)的概率密度计算公式 fy(y) =fx[1/g(y)] | [1/g(y)]’ | = fx(-f/2)|-1/2 l=(1/2)fx(-y/2). 故选D.');
INSERT INTO `danxuan` VALUES (10, '设随机变量 X 〜N(u,2^2),Y 〜N(u,3^2),记p1 =P{X<=u-2},p2=P{丫>=u + 3},则 ( )', 2, 'A', '由于(X-u)/2~N(0,1)，(Y-u)/3~N(0,1)，所以p1=P{(X-u)/2<=-1}=P{(X-u)/2>=1}=1-o(1)，p2=P{(Y-u)/3>=1}=1-o(1)，故p1=p2，而且与u的取值无关. 故选A.');
INSERT INTO `danxuan` VALUES (11, '设二维随机变量(X,Y)的概率密度为 f(x，y)= 4xy，0<=x<=1，0<=y<=1，f(x，y)=0，其他，则当0 <= x <= 1时，X的边缘概率密度为()', 2, 'B', '当 0<= x <= 1 时. fx(x)=∫（-∞, +∞）f(x,y)dy = ∫（0,1）4xydy = 2xy^2I(0,1) = 2x  故选B');
INSERT INTO `danxuan` VALUES (12, '二维随机变量(X,Y)的联合密度函数是f(x,y)，分布函数为F(x,y)，X,Y的边缘分布函数 ,分别是Fx(x), Fy(y), 则∫(-∞, +∞)∫(-∞, +∞)f(u,v)dudv, ∫(-∞, x)∫(-∞, +∞)f(u,v)dudv，∫(-∞, x) ∫(-∞, y)f(u,v)dudv,分别为（）', 2, 'D', '由概率密度性质∫(-∞, +∞) ∫(-∞, +∞)f(u,v)dudv = 1,  由分布函数与概率密度的关系可知, F(x,y) = ∫(-∞, x) ∫(-∞, y) f(u,v)dudv, Fx(x) = F(x,+∞) =∫(-∞, x)∫(-∞, +∞)f(u,v)dudv 故选D.');
INSERT INTO `danxuan` VALUES (13, '设随机变量X,Y独立同分布且X的分布函数为F(x),则F = max{X,Y}的分布函数为 ( )', 2, 'A', 'Fz(z) = P{Z<=z} = P{max{X,Y} <= z} = P{X<=z, Y<=z} = P{X<=z}P{Y<=z}=[F(z)]^2');
INSERT INTO `danxuan` VALUES (14, '设X〜N(-1,2),Y〜N(1,3),且X与丫相互独立，则X + 2Y〜 ( )', 2, 'B', '设X~N(u1, o1^2), Y~N(u2, o2^2), 且X与Y相互独立，则aX+bY~N(au1+bu2, a^2o1^2+b^2o2^2), 由此本题中X+2Y~N(1, 14).故选B.');
INSERT INTO `danxuan` VALUES (15, '设二维随机变量(x,y)的分布律为:图表Y\\X有两行三列,请自行画图。第一行为1/10，2/10，2/10; 第二行为3/10，1/10，1/10；则P{XY=2}等于  ( )', 2, 'C', 'P{XY=2} =P{X= 1,丫 = 2}+P{X= 2,V= 1} = 2/10+ 3/10 = 1/2故选C');
INSERT INTO `danxuan` VALUES (16, '设随机变量X,Y相互独立，且X〜b(16,0. 5) ,y〜(9)，则D(X-2Y+ 1)等于()', 2, 'C', '因为X〜b(16, 0.5),所以 D(X) = np(1-p) = 16 X 0. 5 X 0. 5 = 4. 而丫〜兀(9),则 D(Y) = = 9, 故 D(X-2Y+1) = D(X)+4D(Y) =4 + 4X9 = 40. 因此选C.');
INSERT INTO `danxuan` VALUES (17, '已知随机变量X的分布律为二行儿列，第一行X为：-2，1，x。第二行，Pk为：1/4，p，1/4。且则E(X)=1,  则常数x等于( )', 2, 'B', '因为, 即1/4+p+1/4 = 1， 所以p = 1/2 . 又因为, 所以x = 4,故选B.');
INSERT INTO `danxuan` VALUES (18, '二维随机变量(X, Y)的分布律为3行3列，第一行：X/Y，0，1。第二行：0，1/3，1/3。第三行：1，1/3，0。则(X, Y)的协方差为( )', 2, 'A', 'E(X)=1/3, E(Y)=1/3, E(XY)=0, 则Cov(X,Y)=E(XY)-E(X)E(Y)=-1/9. 故选A.');
INSERT INTO `danxuan` VALUES (19, '设X是一随机变量,E(X) =u, D(X) =o^2(u, o> 0常数)，则对任意常数c,必有( )', 2, 'D', 'E[(X-c)^2] = E[(X–u+u-c)^2] = E[(X – u)^2]+ E[(u – c)^2]+2(u-c)E(X-u) = E[(X – u)^2]+(u-c)^2,  即有E[(X – c)^2]>= E[(X – u)^2] . 故选D.');
INSERT INTO `danxuan` VALUES (20, '设随机变量X和Y都服从正态分布，且它们不相关，则 ( )', 2, 'C', '当X与Y相互独立时,X与Y不相关，反之不然，即X与Y不相关时未必独立,只有当(X,Y) 服从二维正态分布时，不相关与独立才等价, 而本题仅知X和Y服从正态分布，故选项A不正确. 从而选项B,D也不正确. 故选C.');
INSERT INTO `danxuan` VALUES (21, '设X1, X2，…, Xn，…是独立同分布的随机变量序列，第一行Xi为 0,1。第二行Pk为1-p,p。且i=1, 2，…, 0<p<1, 令Yn∑(i=1,n)Xi, O(x)为标准正态分布函数，则lim(n){(Yn-np)/(np(i-p))^1/2)<=1}等于( )', 2, 'B', '因为Yn=∑(i=1,n)Xi~b(n,p)由中心极限定理知, Yn的极限分布为N(np, np(1-p))，(时)，所以 limP() {(Yn-np)/(np(i-p))^1/2)<=1} =o(1) 故选B.');
INSERT INTO `danxuan` VALUES (22, '假设随机变量X1,X2，…,Xn,…独立同分布且E(Xn)= O,则lim(n)P{∑(i=1,n)Xi<n}等于( )', 2, 'D', '由此题条件及所求概率，考虑用辛钦大数定律计算得1，故选D.');
INSERT INTO `danxuan` VALUES (23, '设随机变量X1,X2, ……,X50相互独立，且Xi服从泊松分布π(0.1), i = 1,2,……,50, 则∑(i=1,50)Xi近似服从( )', 2, 'A', '因为X1,X2, ……,X50独立同分布，且Xi ~π(0.1), 则 E(Xi) = D(Xi) = 0.1. 故由中心极限定理， \r\n∑(i=1,50)Xi~N(5,5)故选A');
INSERT INTO `danxuan` VALUES (24, '4.设o(x)为标准正态分布函数,Xi=0, A不发生，Xi=1, A发生,  (i= 1,2,……，100),且P(A) =0.8, X1, X2,……,X100相互独立，令y=∑(i=1,100)Xi，则由中心极限定理知Y的分布函数F(y)近似于( )', 2, 'B', '因为Y= ∑(i=1,100)Xi~b(100,0.8). 所以根据中心极限定理， 近似地 y ~ N(80,16) , 则F(y)o((y-80)/16^1/2)= o((y-80)/4). 故选B.');
INSERT INTO `danxuan` VALUES (25, '设X1,X2, ……,Xn,……是相互独立的随机变量序列,Xn服从参数为n的指数分布(n = 1, 2,…),则下列选项中服从切比雪夫大数定律的随机变量序列是 ( )', 2, 'D', '由条件Xn〜E(n),得 E(Xn)=1/n, D(Xn)=1/n^2. 选项 A,E(Xn) = 1/n，D(Xn)=1/n^2； 选项 B, E(n^2Xn) = n, D(n^2Xn) = n^2; 选项 C，E(Xn/n)=1/n^2，D(Xn/n)=1/n^4. 可知选项A,B,C中随机变量序列的期望和方差均随着n的变化而变化.只有选项D,E(nXn)= D(nXn) = 1,期望和方差均为常数，故选D. ');
INSERT INTO `danxuan` VALUES (26, '设随机变量X〜t(n)(n>1),Y = 1/X^2,则 ( )', 2, 'C', '设X=U/(V/n)^1/2, 其中U~N(0,1),V~X^2(n). 则Y=1/X^2=(V/n)/(U^2/1)~F(n,1), \r\n其中U^2~X^2. 故选C.');
INSERT INTO `danxuan` VALUES (27, '设Xi ,X2 ,X3 ,X4是来自正态总体N(0,2^2)的简单随机样本,X = a(X1 - 2X2)^2 +b(3X3 -4X4 )^2，若统计量X服从X^2分布，则 ( )', 2, 'D', '令Y1=X1-2X2，\r\n则Y1~N(0, 20), 即Y1/20^1/2~N(0, 1), 所以a =1/20时， a^1/2(X1-2X2)~N(0, 1), 同样令Y2 =3X3-4X4, 则Y2~N(0, 100), 即Y2/10~N(0, 1), 所以b= 1/100时，b^1/2(3X3-4X4)~ N(0, 1). 由X^2分布定义可知，若a(X1-2X2)^2+b(3X3-4X4)^2~X^2(2), 则a =1/20, b=1/100.');
INSERT INTO `danxuan` VALUES (28, '设总体X〜N(u, o^2), 其中u是已知的，而o^2未知, X1,X2,X3是从总体中抽取的一个简单随机样本，则下列表达式中，不属于统计量的是 ( )', 2, 'C', '因为统计量中不应含有未知参数，故A,B, D都是统计量，而C不是统计量. 故选C');
INSERT INTO `danxuan` VALUES (29, '设随机变量X服从自由度为n的t分布，定义ta满足P{X<=ta} = 1-a(0<a<1).若 已知 P{|X|>x} =b (b>0), 则 x 等于 ( )', 2, 'D', '根据t分布的对称性及b>0，可知x>0, 从而P{X<=x}=1-P{X<x}=1-1/2P{|X|>x}=1-b/2. 根据题设P{X<=ta}=1-a定义的ta, 可知x=tb/2. 故选D.');
INSERT INTO `danxuan` VALUES (30, '设X1,X2,X3,X4为来自总体X〜N(1, o^2)的简单随机样本，则统计量(X1-X2)/|X3+X4-2|服从的分布为 ( )', 2, 'B', '因X1,X2,X3,X4为来自总体N(1, o^2)(o>0) 的简单随机样本，则有X1-X2~N(0, 2o^2), (X1-X2)/(o2^1/2)~N(0, 1), X3+X4-2~ N(0, 2o^2), (X3+X4-2) /(o2^1/2)~ N(0, 1),  [(X1-X2)/(o2^1/2)] / [(X3+X4-2) /(o2^1/2) ] ~ t(1).  即(X1-X2)/|X3+X4-2|~t(1), 故选B.');
INSERT INTO `danxuan` VALUES (31, '设总体X〜N(u,4),其中u为未知参数X1,X2,X3为样本，下面四个关于u的无偏估计中，采用有效性这一标准来衡量,最好的一个是( )', 2, 'D', '由有效性的定义可知，在无偏估计量中，方差小的估计量更有效. 本题四个无偏估计量中, ^u=1/3(X1 +X2+X3)的方差最小，为D(^u) =4/3，是最好的. 故选D.');
INSERT INTO `danxuan` VALUES (32, '设总体X〜N(u, o^2)，则u的置信区间长度L与置信水平1 -a的关系是 ( )', 2, 'A', '无论o^2是否已知，由标准正态分布或t分布的几何意义都可看出，当样本容量n固定时，置信水平提高,则置信区间长度变大，反之，则长度减少.(由公式也能得出同样结论).因此A正确. 故选A.');
INSERT INTO `danxuan` VALUES (33, '设总体X服从参数为λ的泊松分布, X1,……,Xn是其简单随机样本，均值为’X’,方差为S^2.已知^ λ= a’X’ + (2-3a)S^2 为λ的无偏估计, 则a等于 ( )', 2, 'C', '因为X〜π(λ), 所以E(X) = D(X)= λ， 则 E(X) = E(‘X’) = λ,  E(S^2) = D(X) = λ,	 又E(^λ)= λ，则 aλ + (2 - 3a) λ = λ, 解得a = 1/2.故选C.');
INSERT INTO `danxuan` VALUES (34, '设总体X的数学期望u与方差o^2存在,X1,X2,…,Xn,是X的样本，则可以作为o^2的无偏 估计的是 ()', 2, 'A', '当u未知时，1/n∑(i=1, n)(Xi-u)^2与1/n∑(i=1, n)(Xi-u)^2都不是统计量，因而不能作为o^2的估计量.  故C，D不正确。当u已知时，1/n∑(i=1, n)(Xi-u)^2与1/n∑(i=1, n)(Xi-u)^2都是统计量，其中E[∑(i=1, n)(Xi-u)^2/n]= E[∑(i=1, n)(Xi-u)^2]/n=∑(i=1, n)E(Xi-u)^2/n=∑(i=1, n)D(Xi)/n=∑(i=1, n)o^2/n=o^2.E[∑(i=1, n)(Xi-u)^2/(n-1)]=[n/(n-1)]o^2则1/n∑(i=1, n)(Xi-u)^2是o^2的无偏估计量. 故选A.');
INSERT INTO `danxuan` VALUES (35, '设总体X〜N(u,o^2), u, o^2 为未知参数, X1, X2，…,Xn为样本，则u的置信水平为1 - a的置信区间为 ( )', 2, 'C', 'O^2未知时，u的置信区间应为(‘X’-(t a/2(n-1))S/(n^1/2),  ‘X’+(t a/2(n-1))S/(n^1/2)),  故选C.');
INSERT INTO `danxuan` VALUES (36, '设 0<P(A)<1,  0<P(B)<1,  P(A | B)+P(‘A’ |’B’) = 1,下列选项中，正确的是 ( )', 2, 'A', '因为P(A | B)=P(AB)/P(B),  p(‘A’|’B’)=P(‘A’’B\')/P(‘B’)=1-P(A∪B)/1-P(B),  所以1= P(AB)/P(B)+ 1-P(A∪B)/1-P(B),  整理得P(AB)[1-P(B)]=P(B)[P(A)-P(AB)],  从而P(AB)=P(B)P(A).  故选A.');
INSERT INTO `danxuan` VALUES (37, '设F1(x)与F2(x)分别为随机变量X1与X2的分布函数，为使F(x) =aF1 (X)-bF2(X) 是某一随机变量的分布函数，在下列给定的各组数值中应取 ( )', 2, 'A', '由分布函数的性质,  lim(x→+∞)F1(X)=1,  lim(x→+∞)F2(X)=1,  要使F(x)=aF1(x)-bF2(x)为某一随机变量的分布函数，则lim(x→+∞)F(X)=1,  即a lim(x→+∞)F1(X)-b lim(x→+∞)F2(X)=1,  因此a-b=1.  故选A.');
INSERT INTO `danxuan` VALUES (38, '设A,B,C是三个相互独立的随机事件，且0 < P(C) < 1.下列给定的四对事件中,不相互\r\n独立的是 ( )', 2, 'B', 'A,B,C相互独立时，选项A,C,D显然独立， 故选B. 事实上，由0 <P(C)<1知C并非必然事件与不可能事件，故’AB’与’C’不独立.');
INSERT INTO `danxuan` VALUES (39, '设随机变量X服从二项分布，且E(X) =2.4,  D(X) = 1.44,  则二项分布的参数n,p的值\r\n为 ( )', 2, 'B', '因为X服从二项分布，参数为n,p, 所以E(X) = np ,D(X)=npq, 且 np=2.4,  np(1-p)=1.44, 解方程组可得n=6,  p=0.4,  故选B.');
INSERT INTO `danxuan` VALUES (40, '设随机变量(X,Y)服从二维正态分布，且X与Y不相关, fx(x), fy(y)分别表示X,Y的概率密度，则在Y = y的条件下, X的条件概率密度fx|y(x|y)为 ( )', 2, 'A', '方法一：由于(x,y)服从二维正态分布，因此X与Y不相关可知X与Y相互独立.于是有fx|y(x I y) = fx (x).\r\n方法二: 由于X与Y不相关，即ρ=0,  因此(X, Y)的联合密度为f(x,y)=(1/2πo1o2)e^(-1/2)([(x-u1)/o1]^2+[(y-u2)/o2]^2).  而X,  Y的边缘概率密度分别为fx(x)=(1/[(2π^1/2)o1])e^-{[(x-u1)^2]/(2o1^2)},  fy(y)=(1/[(2π^1/2)o2])e^-{[(x-u2)^2]/(2o2^2)},');

-- ----------------------------
-- Table structure for datika
-- ----------------------------
DROP TABLE IF EXISTS `datika`;
CREATE TABLE `datika`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `eid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of datika
-- ----------------------------

-- ----------------------------
-- Table structure for emailcode
-- ----------------------------
DROP TABLE IF EXISTS `emailcode`;
CREATE TABLE `emailcode`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户邮箱',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '验证码',
  `type` int(1) NOT NULL COMMENT '验证类型',
  `end` timestamp NULL DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`, `email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of emailcode
-- ----------------------------
INSERT INTO `emailcode` VALUES (5, '905218949@qq.com', '346789', 1, '2023-04-16 01:48:31');
INSERT INTO `emailcode` VALUES (6, '905218949@qq.com', '345689', 2, '2023-03-14 20:21:44');
INSERT INTO `emailcode` VALUES (8, '1931255001@qq.com', '012479', 1, '2022-11-14 13:49:55');
INSERT INTO `emailcode` VALUES (9, '1765517640@qq.com', '014568', 1, '2022-11-14 12:21:12');
INSERT INTO `emailcode` VALUES (10, '1765517640@qq.com', '012345', 2, '2022-11-14 11:58:14');
INSERT INTO `emailcode` VALUES (11, '3082131327@qq.com', '034678', 1, '2022-09-30 16:46:49');
INSERT INTO `emailcode` VALUES (12, '2410494058@qq.com', '013568', 1, '2022-11-13 22:14:46');
INSERT INTO `emailcode` VALUES (15, '15707408@qq.com', '134568', 1, '2022-11-13 22:11:18');
INSERT INTO `emailcode` VALUES (16, '', '123689', 1, '2022-11-13 15:00:25');
INSERT INTO `emailcode` VALUES (17, '15707408@qq.com', '012367', 2, '2022-11-13 16:57:30');
INSERT INTO `emailcode` VALUES (18, '2312958994@qq.com', '015679', 1, '2022-11-13 22:19:17');
INSERT INTO `emailcode` VALUES (19, '1931255001@qq.com', '134568', 2, '2022-11-15 22:40:18');
INSERT INTO `emailcode` VALUES (20, '2312958994@qq.com', '024578', 2, '2023-03-17 15:21:25');
INSERT INTO `emailcode` VALUES (21, '320938995@qq.com', '012349', 1, '2023-04-12 00:01:45');

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cid` int(5) NOT NULL,
  `startTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `endTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES (1, '第一章(A卷选择题)', 1, '2023-04-03 23:02:36', '2023-04-27 17:56:17');
INSERT INTO `exam` VALUES (2, '第二章(A卷选择题)', 1, '2023-04-03 23:02:34', '2023-04-27 20:06:05');
INSERT INTO `exam` VALUES (3, '第三章(A卷选择题)', 1, '2023-04-03 23:02:29', '2023-04-27 23:02:27');
INSERT INTO `exam` VALUES (4, '第四章(A卷选择题)', 1, '2023-04-06 21:25:08', '2023-04-27 21:25:04');
INSERT INTO `exam` VALUES (5, '第五章A卷(选择题)', 1, '2023-04-14 19:54:00', '2023-04-27 19:53:57');
INSERT INTO `exam` VALUES (6, '第六章(A卷选择题)', 1, '2023-04-14 20:00:21', '2023-04-14 20:00:20');
INSERT INTO `exam` VALUES (7, '第七章(A卷选择题)', 1, '2023-04-14 20:07:00', '2023-04-14 20:06:58');
INSERT INTO `exam` VALUES (8, '期末(A卷选择题)', 1, '2023-04-14 20:13:34', '2023-04-27 20:13:30');

-- ----------------------------
-- Table structure for exam_danxuan
-- ----------------------------
DROP TABLE IF EXISTS `exam_danxuan`;
CREATE TABLE `exam_danxuan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `eid` int(11) NOT NULL,
  `dxid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of exam_danxuan
-- ----------------------------
INSERT INTO `exam_danxuan` VALUES (1, 1, 1);
INSERT INTO `exam_danxuan` VALUES (2, 1, 2);
INSERT INTO `exam_danxuan` VALUES (3, 1, 3);
INSERT INTO `exam_danxuan` VALUES (4, 1, 4);
INSERT INTO `exam_danxuan` VALUES (5, 1, 5);
INSERT INTO `exam_danxuan` VALUES (6, 2, 6);
INSERT INTO `exam_danxuan` VALUES (7, 2, 7);
INSERT INTO `exam_danxuan` VALUES (8, 2, 8);
INSERT INTO `exam_danxuan` VALUES (9, 2, 9);
INSERT INTO `exam_danxuan` VALUES (10, 2, 10);
INSERT INTO `exam_danxuan` VALUES (11, 3, 11);
INSERT INTO `exam_danxuan` VALUES (12, 3, 12);
INSERT INTO `exam_danxuan` VALUES (13, 3, 13);
INSERT INTO `exam_danxuan` VALUES (14, 3, 14);
INSERT INTO `exam_danxuan` VALUES (15, 3, 15);
INSERT INTO `exam_danxuan` VALUES (16, 4, 16);
INSERT INTO `exam_danxuan` VALUES (17, 4, 17);
INSERT INTO `exam_danxuan` VALUES (18, 4, 18);
INSERT INTO `exam_danxuan` VALUES (19, 4, 19);
INSERT INTO `exam_danxuan` VALUES (20, 4, 20);
INSERT INTO `exam_danxuan` VALUES (21, 5, 21);
INSERT INTO `exam_danxuan` VALUES (22, 5, 22);
INSERT INTO `exam_danxuan` VALUES (23, 5, 23);
INSERT INTO `exam_danxuan` VALUES (24, 5, 24);
INSERT INTO `exam_danxuan` VALUES (25, 5, 25);
INSERT INTO `exam_danxuan` VALUES (26, 6, 26);
INSERT INTO `exam_danxuan` VALUES (27, 6, 27);
INSERT INTO `exam_danxuan` VALUES (28, 6, 28);
INSERT INTO `exam_danxuan` VALUES (29, 6, 29);
INSERT INTO `exam_danxuan` VALUES (30, 6, 30);
INSERT INTO `exam_danxuan` VALUES (31, 7, 31);
INSERT INTO `exam_danxuan` VALUES (32, 7, 32);
INSERT INTO `exam_danxuan` VALUES (33, 7, 33);
INSERT INTO `exam_danxuan` VALUES (34, 7, 34);
INSERT INTO `exam_danxuan` VALUES (35, 7, 35);
INSERT INTO `exam_danxuan` VALUES (36, 8, 36);
INSERT INTO `exam_danxuan` VALUES (37, 8, 37);
INSERT INTO `exam_danxuan` VALUES (38, 8, 38);
INSERT INTO `exam_danxuan` VALUES (39, 8, 39);
INSERT INTO `exam_danxuan` VALUES (40, 8, 40);

-- ----------------------------
-- Table structure for helpdocument
-- ----------------------------
DROP TABLE IF EXISTS `helpdocument`;
CREATE TABLE `helpdocument`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of helpdocument
-- ----------------------------
INSERT INTO `helpdocument` VALUES (1, '补概app介绍', '补概App软件实现了将数学实验与概率统计知识动画化，帮助同学一步步深入地理解抽象概念，让用户增加学习趣味性。', 1);
INSERT INTO `helpdocument` VALUES (2, '题库功能介绍', '用户登录后，第一次使用题库需要先加入班级。题库有开始时间和结束时间限制，在结束时间前，可以反复做题。查看解析功能只有当交卷后才能查看。点击答题卡可以看到自己做过的内容。在交完卷后，点击答题卡，做对的显示蓝色，做错的显示红色，点对应选项方可定位到该题。收藏题目功能目前暂时未开放，敬请期待。', 1);
INSERT INTO `helpdocument` VALUES (3, '班级功能介绍', '班级功能默认一个学生只能加入一个班级（系统设计时只考虑到一个学生只上一门概率论的情况）。加入过班级后，后续将关闭加入班级页面，并友好弹出无需再加入班级提示框。用户可以通过班级号加入对应班级。', 1);
INSERT INTO `helpdocument` VALUES (13, '关于头像功能的介绍', '目前用户绑定qq邮箱后，系统将自动获取用户qq头像，用户无需再上传头像，本系统里头像会随用户在qq里设置的头像变化而变化。', 1);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `mid` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `component` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iconCls` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keepAlive` tinyint(1) NULL DEFAULT NULL,
  `requireAuth` tinyint(1) NULL DEFAULT NULL,
  `enabled` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`mid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/', NULL, NULL, '所有', NULL, NULL, NULL, 1);
INSERT INTO `menu` VALUES (2, '/', '/', 'HomeView', '用户管理', 'el-icon-s-custom', NULL, 1, 1);
INSERT INTO `menu` VALUES (3, '/', '/user/teacher', 'user/Teacher', '老师管理', NULL, NULL, 1, 1);
INSERT INTO `menu` VALUES (4, '/', '/user/student', 'user/Student', '学生管理', NULL, NULL, 1, 1);
INSERT INTO `menu` VALUES (5, '/', '/', 'HomeView', '院系管理', 'el-icon-edit', NULL, 1, 1);
INSERT INTO `menu` VALUES (6, '/', '/school/class', 'school/Class', '班级管理', NULL, NULL, 1, 1);
INSERT INTO `menu` VALUES (7, '/', '/school/exam', 'school/Exam', '考试管理', 'el-icon-load', NULL, 1, 1);
INSERT INTO `menu` VALUES (8, '/', '/', 'HomeView', '其他设置', 'el-icon-bell', NULL, 1, 1);
INSERT INTO `menu` VALUES (9, '/', '/other/help', 'other/Help', '帮助文档', NULL, NULL, 1, 1);
INSERT INTO `menu` VALUES (10, ' /', '/other/update', 'other/Update', '更新日志', NULL, NULL, 1, 1);

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  `child` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (1, 2, 4, 3);
INSERT INTO `menu_role` VALUES (2, 2, 4, 4);
INSERT INTO `menu_role` VALUES (3, 2, 3, 4);
INSERT INTO `menu_role` VALUES (4, 5, 4, 6);
INSERT INTO `menu_role` VALUES (5, 5, 4, 7);
INSERT INTO `menu_role` VALUES (6, 5, 3, 6);
INSERT INTO `menu_role` VALUES (7, 5, 3, 7);
INSERT INTO `menu_role` VALUES (8, 8, 4, 9);
INSERT INTO `menu_role` VALUES (9, 8, 4, 10);

-- ----------------------------
-- Table structure for mydanxuan
-- ----------------------------
DROP TABLE IF EXISTS `mydanxuan`;
CREATE TABLE `mydanxuan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dxid` int(11) NOT NULL,
  `userAnswer` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userFavor` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `eid` int(10) NOT NULL,
  `uid` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of mydanxuan
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rname_zh` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_common', '普通用户');
INSERT INTO `role` VALUES (2, 'ROLE_student', '学生');
INSERT INTO `role` VALUES (3, 'ROLE_teacher', '老师');
INSERT INTO `role` VALUES (4, 'ROLE_master', '管理员');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `enabled` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 1,
  `accountNonExpired` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 1,
  `accountNonLocked` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 1,
  `credentialsNonExpired` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 1,
  `accountCreated` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '$2a$10$YZz4lCUZAyFf75xbThFDnunwRTgQ6GEay3pHmWa3tF2qK50Jy78Ji', 1, 1, 1, 1, '2022-11-18 12:33:47');
INSERT INTO `user` VALUES (22, 'lp', '$2a$10$0NqBsM0OmUvND9xzQG1ateooFaH3p//qCqX5MLnNc.u/ACqGBHvH2', 1, 1, 1, 1, '2022-11-18 12:33:51');
INSERT INTO `user` VALUES (23, 'Tonmi', '$2a$10$lznlKuvXufFgUSxerLvMv.d9IoURMxY.iH7CUhdPfYBJz5WaP5SO6', 1, 1, 1, 1, '2022-11-18 12:33:53');
INSERT INTO `user` VALUES (24, 'infun', '$2a$10$OJjf15JHHYtf4eWFpRDjxO3wdVdRjyANX8.mVjk0c3e9bZneyJSOm', 1, 1, 1, 1, '2022-11-18 12:33:56');
INSERT INTO `user` VALUES (25, 'wowo', '$2a$10$ZunuU9kDza/sUk5DKj05meH0R19C/Bstw71hjLk7wicnebdy9RS3.', 1, 1, 1, 1, '2022-11-18 12:33:59');
INSERT INTO `user` VALUES (26, 'test', '$2a$10$lznlKuvXufFgUSxerLvMv.d9IoURMxY.iH7CUhdPfYBJz5WaP5SO6', 0, 1, 1, 1, '2023-04-11 23:39:45');
INSERT INTO `user` VALUES (27, '相同宇', '$2a$10$X2M.wvMgoDKxY3.5p/4mKOgMDmk7u4gUJrCdbQCsEiFBfMAezvfZO', 0, 1, 1, 1, '2023-04-14 17:04:35');
INSERT INTO `user` VALUES (32, 'test123', '$2a$10$vIbqCYV9KGcbCZe8Kgm0PezxQ9wFd6L1xAu6j6VF5hSdSxxpcrKki', 1, 1, 1, 1, '2023-04-16 01:44:25');

-- ----------------------------
-- Table structure for user_class
-- ----------------------------
DROP TABLE IF EXISTS `user_class`;
CREATE TABLE `user_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uid`(`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_class
-- ----------------------------
INSERT INTO `user_class` VALUES (1, 1, 22);
INSERT INTO `user_class` VALUES (2, 1, 24);
INSERT INTO `user_class` VALUES (3, 1, 23);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'bugai',
  `communicationEnabled` tinyint(1) NOT NULL DEFAULT 1,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uid`(`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 1, '9052189492@qq.com', 'bugai', 1, 'http://q.qlogo.cn/headimg_dl?dst_uin=9052189492&spec=640&img_type=jpg');
INSERT INTO `user_info` VALUES (12, 22, '15707408@qq.com', '管理员', 1, 'http://q.qlogo.cn/headimg_dl?dst_uin=15707408&spec=640&img_type=jpg');
INSERT INTO `user_info` VALUES (13, 23, '2410494058@qq.com', '龙坤岳', 1, 'http://q.qlogo.cn/headimg_dl?dst_uin=2410494058&spec=640&img_type=jpg');
INSERT INTO `user_info` VALUES (14, 24, '2312958994@qq.com', 'bugai', 1, 'http://q.qlogo.cn/headimg_dl?dst_uin=2312958994&spec=640&img_type=jpg');
INSERT INTO `user_info` VALUES (15, 25, '1765517640@qq.com', 'bugai', 1, 'http://q.qlogo.cn/headimg_dl?dst_uin=1765517640&spec=640&img_type=jpg');
INSERT INTO `user_info` VALUES (16, 26, '', '龙坤岳', 1, NULL);
INSERT INTO `user_info` VALUES (17, 27, '320938995t@qq.com', 'bugai', 1, 'http://q.qlogo.cn/headimg_dl?dst_uin=320938995t&spec=640&img_type=jpg');
INSERT INTO `user_info` VALUES (27, 32, '905218949@qq.com', 'bugai', 1, 'http://q.qlogo.cn/headimg_dl?dst_uin=905218949&spec=640&img_type=jpg');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 22, 4);
INSERT INTO `user_role` VALUES (3, 23, 4);
INSERT INTO `user_role` VALUES (4, 24, 2);
INSERT INTO `user_role` VALUES (5, 25, 2);
INSERT INTO `user_role` VALUES (6, 26, 2);
INSERT INTO `user_role` VALUES (9, 32, 1);

-- ----------------------------
-- Table structure for xuanxiang
-- ----------------------------
DROP TABLE IF EXISTS `xuanxiang`;
CREATE TABLE `xuanxiang`  (
  `xid` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `dxid` int(11) NOT NULL,
  PRIMARY KEY (`xid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 161 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of xuanxiang
-- ----------------------------
INSERT INTO `xuanxiang` VALUES (1, 'A', '0. 7 ', 1);
INSERT INTO `xuanxiang` VALUES (2, 'B', '0. 8', 1);
INSERT INTO `xuanxiang` VALUES (3, 'C', '0. 85', 1);
INSERT INTO `xuanxiang` VALUES (4, 'D', '0. 9', 1);
INSERT INTO `xuanxiang` VALUES (5, 'A', 'A 与BC独立', 2);
INSERT INTO `xuanxiang` VALUES (6, 'B', 'AB与AU C独立', 2);
INSERT INTO `xuanxiang` VALUES (7, 'C', 'AB与AC独立', 2);
INSERT INTO `xuanxiang` VALUES (8, 'D', 'AUB与AU C独立', 2);
INSERT INTO `xuanxiang` VALUES (9, 'A', 'P(C) = P(AB) ', 3);
INSERT INTO `xuanxiang` VALUES (10, 'B', ' P(C) = P(A U B) ', 3);
INSERT INTO `xuanxiang` VALUES (11, 'C', 'P(C)>= P(A) + P(B) - 1', 3);
INSERT INTO `xuanxiang` VALUES (12, 'D', 'P(C) < =P(A) + P(B) -1', 3);
INSERT INTO `xuanxiang` VALUES (13, 'A', '2^2 / 4^2', 4);
INSERT INTO `xuanxiang` VALUES (14, 'B', ')C(1,2) / C(2,4)', 4);
INSERT INTO `xuanxiang` VALUES (15, 'C', '2! / A(2,4)', 4);
INSERT INTO `xuanxiang` VALUES (16, 'D', '2! / 4!', 4);
INSERT INTO `xuanxiang` VALUES (17, 'A', 'P(A)', 5);
INSERT INTO `xuanxiang` VALUES (18, 'B', 'P(AB)', 5);
INSERT INTO `xuanxiang` VALUES (19, 'C', 'P(A U B)', 5);
INSERT INTO `xuanxiang` VALUES (20, 'D', '1', 5);
INSERT INTO `xuanxiang` VALUES (21, 'A', '0. 0016', 6);
INSERT INTO `xuanxiang` VALUES (22, 'B', '0. 0272', 6);
INSERT INTO `xuanxiang` VALUES (23, 'C', '0. 4096', 6);
INSERT INTO `xuanxiang` VALUES (24, 'D', '0. 8192', 6);
INSERT INTO `xuanxiang` VALUES (25, 'A', ' F(+∞)= 1', 7);
INSERT INTO `xuanxiang` VALUES (26, 'B', 'F(-∞)= 0 ', 7);
INSERT INTO `xuanxiang` VALUES (27, 'C', '0 < =F(x) <= 1', 7);
INSERT INTO `xuanxiang` VALUES (28, 'D', 'F(x)为连续函数', 7);
INSERT INTO `xuanxiang` VALUES (29, 'A', 'f1(x)f2(x)', 8);
INSERT INTO `xuanxiang` VALUES (30, 'B', '2f2(x)F1(x)', 8);
INSERT INTO `xuanxiang` VALUES (31, 'C', 'f1(x)F2(x)', 8);
INSERT INTO `xuanxiang` VALUES (32, 'D', 'f1(x)F2(x)+f2(x)F1(x)', 8);
INSERT INTO `xuanxiang` VALUES (33, 'A', '2fx(-2y)', 9);
INSERT INTO `xuanxiang` VALUES (34, 'B', 'fx(-y/2)', 9);
INSERT INTO `xuanxiang` VALUES (35, 'C', '-[(1/2)fx(-y/2)]', 9);
INSERT INTO `xuanxiang` VALUES (36, 'D', '(1/2)fx(-y/2)', 9);
INSERT INTO `xuanxiang` VALUES (37, 'A', '对任意实数u有 p1=p2', 10);
INSERT INTO `xuanxiang` VALUES (38, 'B', '对任意实数u有p1< p2', 10);
INSERT INTO `xuanxiang` VALUES (39, 'C', '对任意实数u有p1 > p2', 10);
INSERT INTO `xuanxiang` VALUES (40, 'D', '对u的个别值，有p1=p2', 10);
INSERT INTO `xuanxiang` VALUES (41, 'A', 'fx(x)=1/2x', 11);
INSERT INTO `xuanxiang` VALUES (42, 'B', 'fx(x)=2x', 11);
INSERT INTO `xuanxiang` VALUES (43, 'C', 'fx(x)=1/2y', 11);
INSERT INTO `xuanxiang` VALUES (44, 'D', 'fx(x)=2y', 11);
INSERT INTO `xuanxiang` VALUES (45, 'A', '0, Fx(x), F(x,y)', 12);
INSERT INTO `xuanxiang` VALUES (46, 'B', '1, Fy(y), F(x,y)', 12);
INSERT INTO `xuanxiang` VALUES (47, 'C', 'f(x,y), F(x,y), Fy(y)', 12);
INSERT INTO `xuanxiang` VALUES (48, 'D', '1, Fx(x), F(x,y)', 12);
INSERT INTO `xuanxiang` VALUES (49, 'A', 'F^2(z)	', 13);
INSERT INTO `xuanxiang` VALUES (50, 'B', 'F(x)F(y)', 13);
INSERT INTO `xuanxiang` VALUES (51, 'C', '1-[1-F(z)]^2', 13);
INSERT INTO `xuanxiang` VALUES (52, 'D', '[1-F(x)][1-F(y)]', 13);
INSERT INTO `xuanxiang` VALUES (53, 'A', 'N(1,8)', 14);
INSERT INTO `xuanxiang` VALUES (54, 'B', ' N(1, 14)', 14);
INSERT INTO `xuanxiang` VALUES (55, 'C', 'N(1,22)', 14);
INSERT INTO `xuanxiang` VALUES (56, 'D', 'N(1,40) )', 14);
INSERT INTO `xuanxiang` VALUES (57, 'A', '1/5', 15);
INSERT INTO `xuanxiang` VALUES (58, 'B', '3/10 ', 15);
INSERT INTO `xuanxiang` VALUES (59, 'C', '1/2', 15);
INSERT INTO `xuanxiang` VALUES (60, 'D', '3/5', 15);
INSERT INTO `xuanxiang` VALUES (61, 'A', '-14', 16);
INSERT INTO `xuanxiang` VALUES (62, 'B', '13', 16);
INSERT INTO `xuanxiang` VALUES (63, 'C', '40', 16);
INSERT INTO `xuanxiang` VALUES (64, 'D', '41', 16);
INSERT INTO `xuanxiang` VALUES (65, 'A', '2', 17);
INSERT INTO `xuanxiang` VALUES (66, 'B', '4 ', 17);
INSERT INTO `xuanxiang` VALUES (67, 'C', '6', 17);
INSERT INTO `xuanxiang` VALUES (68, 'D', ' 8', 17);
INSERT INTO `xuanxiang` VALUES (69, 'A', 'Cov(X,Y)=-1/9', 18);
INSERT INTO `xuanxiang` VALUES (70, 'B', 'Cov(X,Y) =0', 18);
INSERT INTO `xuanxiang` VALUES (71, 'C', 'Cov(X,Y)= 1/9', 18);
INSERT INTO `xuanxiang` VALUES (72, 'D', 'Cov(X,Y)= 1/3', 18);
INSERT INTO `xuanxiang` VALUES (73, 'A', 'E[(X - c)^2] = E(X^2)-c^2 ', 19);
INSERT INTO `xuanxiang` VALUES (74, 'B', 'E[(X - c)^2] = E[(X – u)^2]', 19);
INSERT INTO `xuanxiang` VALUES (75, 'C', 'E[(X - c)^2] < E[(X – u)^2]', 19);
INSERT INTO `xuanxiang` VALUES (76, 'D', 'E[(X - c)^2] >= E[(X – u)^2]', 19);
INSERT INTO `xuanxiang` VALUES (77, 'A', 'X与Y一定独立', 20);
INSERT INTO `xuanxiang` VALUES (78, 'B', ')(X,Y)服从二维正态分布', 20);
INSERT INTO `xuanxiang` VALUES (79, 'C', ' X与Y未必独立', 20);
INSERT INTO `xuanxiang` VALUES (80, 'D', 'X+Y服从一维正态分布', 20);
INSERT INTO `xuanxiang` VALUES (81, 'A', '0', 21);
INSERT INTO `xuanxiang` VALUES (82, 'B', '0(1)', 21);
INSERT INTO `xuanxiang` VALUES (83, 'C', '1-o(1)', 21);
INSERT INTO `xuanxiang` VALUES (84, 'D', '1', 21);
INSERT INTO `xuanxiang` VALUES (85, 'A', '0', 22);
INSERT INTO `xuanxiang` VALUES (86, 'B', '1/4	', 22);
INSERT INTO `xuanxiang` VALUES (87, 'C', '1/2', 22);
INSERT INTO `xuanxiang` VALUES (88, 'D', '1', 22);
INSERT INTO `xuanxiang` VALUES (89, 'A', 'N(5,5) ', 23);
INSERT INTO `xuanxiang` VALUES (90, 'B', 'N(1/5, 1/5)', 23);
INSERT INTO `xuanxiang` VALUES (91, 'C', 'N(5, 1/5)', 23);
INSERT INTO `xuanxiang` VALUES (92, 'D', 'N(0.1, 1/500)', 23);
INSERT INTO `xuanxiang` VALUES (93, 'A', 'o(y)', 24);
INSERT INTO `xuanxiang` VALUES (94, 'B', 'o((y-80)/4)', 24);
INSERT INTO `xuanxiang` VALUES (95, 'C', 'o(16y+ 80)', 24);
INSERT INTO `xuanxiang` VALUES (96, 'D', 'o(4y+ 80)', 24);
INSERT INTO `xuanxiang` VALUES (97, 'A', 'X1,X2, ……,Xn,……', 25);
INSERT INTO `xuanxiang` VALUES (98, 'B', 'X1,2^2X2, ……,n^2Xn,……', 25);
INSERT INTO `xuanxiang` VALUES (99, 'C', 'X1,X2/2, ……,Xn/n,……', 25);
INSERT INTO `xuanxiang` VALUES (100, 'D', 'X1, 2X2, ……,nXn,……', 25);
INSERT INTO `xuanxiang` VALUES (101, 'A', 'Y〜X^2(n)', 26);
INSERT INTO `xuanxiang` VALUES (102, 'B', 'Y〜X^2(n-1)', 26);
INSERT INTO `xuanxiang` VALUES (103, 'C', 'Y~ F(n,1)	', 26);
INSERT INTO `xuanxiang` VALUES (104, 'D', 'Y〜F(1,n)', 26);
INSERT INTO `xuanxiang` VALUES (105, 'A', 'a = 20,  b = 100', 27);
INSERT INTO `xuanxiang` VALUES (106, 'B', 'a =20^1/2,  b= 10', 27);
INSERT INTO `xuanxiang` VALUES (107, 'C', 'a =1/20^1/2,  b=1/10 ', 27);
INSERT INTO `xuanxiang` VALUES (108, 'D', 'a = 1/20,  b=1/100', 27);
INSERT INTO `xuanxiang` VALUES (109, 'A', 'X1 +X2+X3', 28);
INSERT INTO `xuanxiang` VALUES (110, 'B', 'min{X1,X2,X3}', 28);
INSERT INTO `xuanxiang` VALUES (111, 'C', '(X1^2+X2^2+X3^2)/o^2', 28);
INSERT INTO `xuanxiang` VALUES (112, 'D', 'X1 + 2u', 28);
INSERT INTO `xuanxiang` VALUES (113, 'A', 't1-b', 29);
INSERT INTO `xuanxiang` VALUES (114, 'B', 't1-b/2	', 29);
INSERT INTO `xuanxiang` VALUES (115, 'C', 'tb', 29);
INSERT INTO `xuanxiang` VALUES (116, 'D', 'tb/2', 29);
INSERT INTO `xuanxiang` VALUES (117, 'A', 'N(O,1) ', 30);
INSERT INTO `xuanxiang` VALUES (118, 'B', 't(1)', 30);
INSERT INTO `xuanxiang` VALUES (119, 'C', ' X^2(1)', 30);
INSERT INTO `xuanxiang` VALUES (120, 'D', 'F(1, 1)', 30);
INSERT INTO `xuanxiang` VALUES (121, 'A', '(1/6)X1+(1/3)X2+(1/2)X3	', 31);
INSERT INTO `xuanxiang` VALUES (122, 'B', '(1/5)X1+(2/5)X2+(2/5)X3', 31);
INSERT INTO `xuanxiang` VALUES (123, 'C', '(2/7)X1+(5/7)X2', 31);
INSERT INTO `xuanxiang` VALUES (124, 'D', '(1/3)X1+(1/3)X2+(1/3)X3', 31);
INSERT INTO `xuanxiang` VALUES (125, 'A', '1 -a减小时,L变小', 32);
INSERT INTO `xuanxiang` VALUES (126, 'B', '1 -a减小时,L增大', 32);
INSERT INTO `xuanxiang` VALUES (127, 'C', '1 -a减小时,L不变', 32);
INSERT INTO `xuanxiang` VALUES (128, 'D', '1 -a减小时,L增减不定', 32);
INSERT INTO `xuanxiang` VALUES (129, 'A', '-1', 33);
INSERT INTO `xuanxiang` VALUES (130, 'B', '0', 33);
INSERT INTO `xuanxiang` VALUES (131, 'C', '1/2', 33);
INSERT INTO `xuanxiang` VALUES (132, 'D', '1', 33);
INSERT INTO `xuanxiang` VALUES (133, 'A', '当u已知时，1/n∑(i=1, n)(Xi-u)^2', 34);
INSERT INTO `xuanxiang` VALUES (134, 'B', '当u已知时，1/n∑(i=1, n)(Xi-u)^2', 34);
INSERT INTO `xuanxiang` VALUES (135, 'C', '当u未知时，1/n∑(i=1, n)(Xi-u)^2', 34);
INSERT INTO `xuanxiang` VALUES (136, 'D', '当u未知时，1/(n-1)∑(i=1, n)(Xi-u)^2', 34);
INSERT INTO `xuanxiang` VALUES (137, 'A', '(‘X’-(u a/2)o/(n^1/2),  ‘X’+(u a/2)o/(n^1/2))', 35);
INSERT INTO `xuanxiang` VALUES (138, 'B', '(’X’-(t a/2(n))S/(n^1/2),  ‘X’+(t a/2(n))S/(n^1/2))', 35);
INSERT INTO `xuanxiang` VALUES (139, 'C', '(‘X’-(t a/2(n-1))S/(n^1/2),  ‘X’+(t a/2(n-1))S/(n^1/2))', 35);
INSERT INTO `xuanxiang` VALUES (140, 'D', '((n-1)S^2/X^2 a/2(n-1),  (n-1)S^2/X^2 1-a/2(n-1))', 35);
INSERT INTO `xuanxiang` VALUES (141, 'A', ' A与B相互独立', 36);
INSERT INTO `xuanxiang` VALUES (142, 'B', 'A与B相互对立', 36);
INSERT INTO `xuanxiang` VALUES (143, 'C', 'A与B互不相容', 36);
INSERT INTO `xuanxiang` VALUES (144, 'D', 'A与B互不独', 36);
INSERT INTO `xuanxiang` VALUES (145, 'A', 'a=3/5,  b=-2/5', 37);
INSERT INTO `xuanxiang` VALUES (146, 'B', 'a=2/3,  b=2/3', 37);
INSERT INTO `xuanxiang` VALUES (147, 'C', 'a=-1/2,  b=3/2', 37);
INSERT INTO `xuanxiang` VALUES (148, 'D', 'a=1/2,  b=-3/2', 37);
INSERT INTO `xuanxiang` VALUES (149, 'A', '‘AUB’ 与 C ', 38);
INSERT INTO `xuanxiang` VALUES (150, 'B', '’AC’与 ‘C’ ', 38);
INSERT INTO `xuanxiang` VALUES (151, 'C', '’A-B’与 ‘C’ ', 38);
INSERT INTO `xuanxiang` VALUES (152, 'D', '‘AB’ 与 ‘C’', 38);
INSERT INTO `xuanxiang` VALUES (153, 'A', ' n = 4, p = 0. 6', 39);
INSERT INTO `xuanxiang` VALUES (154, 'B', 'n = 6, p = 0. 4', 39);
INSERT INTO `xuanxiang` VALUES (155, 'C', 'n = 8, p = 0. 3', 39);
INSERT INTO `xuanxiang` VALUES (156, 'D', 'n = 24, p = 0. 1', 39);
INSERT INTO `xuanxiang` VALUES (157, 'A', 'fx(x)', 40);
INSERT INTO `xuanxiang` VALUES (158, 'B', 'fy(y)', 40);
INSERT INTO `xuanxiang` VALUES (159, 'C', 'fx(x)fy(y)', 40);
INSERT INTO `xuanxiang` VALUES (160, 'D', 'fx(x)/fy(y)', 40);

SET FOREIGN_KEY_CHECKS = 1;
