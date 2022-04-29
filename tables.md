[返回README](/README.md)
# sport1 数据库文档
### 基础信息
| 数据库名称 | 版本 | 字符集 | 排序规则 |
| ---- | ---- | ---- | ---- |
| sport1 | 8.0.24 | utf8mb4 | utf8mb4_general_ci |
### 数据库表目录
| 序号 | 表名 | 描述 |
| ---- | ---- | ---- |
| 1 | admin | 管理员信息表 |
| 2 | article | 文章表 |
| 3 | colleges | 学院表 |
| 4 | comment | 文章评论表 |
| 5 | fields | 场地信息表 |
| 6 | games | 比赛信息表 |
| 7 | menus | 管理员权限菜单表 |
| 8 | nums | 运动员编号表 |
| 9 | registrations | 报名信息表 |
| 10 | reports | 成绩信息表（即将合并到比赛信息表中） |
| 11 | site_allocation | 比赛信息表 |
| 12 | user | 用户信息表 |
### 数据库表信息
#### admin(admin)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 管理员自增唯一id |
| username | varchar(255) |  | YES |  | 管理员用户名 |
| password | varchar(255) |  | YES |  | 密码 |
| name | varchar(255) |  | YES |  | 姓名 |
| level | int |  | YES |  | 权限等级，根据level等级大小获取menu菜单表中的菜单项目，值越小权限越大，0为超级管理员 |
| college_id | int | MUL | YES |  | 学院id，外键 |
| is_delete | int(10) unsigned zerofill |  | YES | 0000000000 | 软删除标记 |

#### article(article)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 文章自增唯一id |
| title | varchar(255) |  | YES |  | 文章标题 |
| text | longtext |  | YES |  | 文章正文 |
| admin_id | int | MUL | YES |  | 发布该文章的管理员id |
| create_time | datetime |  | YES |  | 发布时间（自动创建） |

#### colleges(colleges)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 学院自增唯一id |
| name | varchar(255) |  | YES |  | 学院名 |
| max_person | int |  | YES |  | 限制人数（可删） |

#### comment(comment)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 评论自增唯一id |
| article_id | int | MUL | YES |  |  |
| user_id | int | MUL | YES |  |  |
| text | varchar(255) |  | YES |  |  |
| create_time | timestamp |  | YES | CURRENT_TIMESTAMP |  |

#### fields(fields)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 场地自增唯一id |
| name | varchar(255) |  | YES |  | 场地名 |
| max_person | int |  | YES |  | 比赛限制人数 |
| parent_id | int | MUL | YES |  | 上级场地的id，如果为0则是父级场地，可以嵌套多级场地 |

#### games(games)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 比赛自增唯一id |
| game_name | varchar(255) |  | YES |  | 比赛名 |
| next_game | int | MUL | YES |  | 决赛id，对应本表id，如果没有决赛则忽略 |
| gender | int |  | YES |  | 比赛限制的性别，0女，1男，-1不限 |
| field_id | int | MUL | YES |  | 比赛的场地id |
| max_person | int |  | YES |  | 限制报名人数 |
| status | int |  | YES |  | 当前比赛的状态，0报名中，1准备中，2比赛中，3比赛结束 |
| start_time | datetime |  | YES |  | 比赛开始时间 |
| end_time | datetime |  | YES |  | 比赛结束时间 |
| create_time | datetime |  | YES |  | 发布时间（自动创建） |

#### menus(menus)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 权限菜单自增唯一id |
| name | varchar(255) |  | YES |  | 菜单名称 |
| icon | varchar(255) |  | YES |  | 菜单图表代码 |
| path | varchar(255) |  | YES |  | 菜单路径 |
| parent_id | int | MUL | YES |  | 父级菜单id，对应本表id |
| level_id | int | MUL | YES |  | 权限等级，与admin表中的level对应，0为最高权限，值越大权限越小 |

#### nums(nums)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 运动员编号自增唯一id |
| id_num | int |  | YES |  | 运动员编号 |
| college_id | int | MUL | YES |  | 号码所属的学院id |

#### registrations(registrations)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 报名自增唯一id |
| game_id | int | MUL | YES |  | 报名的比赛id |
| user_id | int | MUL | YES |  | 报名的用户id |
| status | int |  | YES |  | 报名状态，0待审核，1通过，-1未通过 |
| reviewer_id | int | MUL | YES |  | 需要管理员审核的id，对应admin表的id |
| create_time | timestamp |  | YES |  | 报名时间 |

#### reports(reports)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 成绩自增唯一id |
| game_id | int | MUL | YES |  | 比赛id |
| user_id | int | MUL | YES |  | 用户id |
| create_time | datetime |  | YES |  | 创建时间 |

#### site_allocation(site_allocation)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 参赛许可自增唯一id |
| user_id | int | MUL | YES |  | 运动员id |
| game_id | int | MUL | YES |  | 比赛id |
| field_id | int | MUL | YES |  | 场地id |

#### user(user)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  | 用户自增唯一id |
| username | varchar(255) |  | YES |  | 用户名 |
| password | varchar(255) |  | YES |  | 密码 |
| real_name | varchar(255) |  | YES |  | 姓名 |
| gender | int |  | YES |  | 性别 |
| college_id | int | MUL | YES |  | 学院id |
| create_time | datetime |  | YES |  | 注册时间 |
| athletes_id | int | MUL | YES |  | 运动员编号，对应nums表中的id，和运动员的衣服贴牌编号一致 |
