[返回README](./README.md)
# sport1 数据库文档
### 基础信息
| 数据库名称 | 版本 | 字符集 | 排序规则 |
| ---- | ---- | ---- | ---- |
| sport1 | 8.0.24 | utf8mb4 | utf8mb4_general_ci |
### 数据库表目录
| 序号 | 表名 | 描述 |
| ---- | ---- | ---- |
| 1 | admin | admin |
| 2 | article | article |
| 3 | colleges | colleges |
| 4 | comment | comment |
| 5 | fields | fields |
| 6 | games | games |
| 7 | menus | menus |
| 8 | nums | nums |
| 9 | registrations | registrations |
| 10 | reports | reports |
| 11 | site_allocation | site_allocation |
| 12 | user | user |
### 数据库表信息
#### admin(admin)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| username | varchar(255) |  | YES |  |  |
| password | varchar(255) |  | YES |  |  |
| name | varchar(255) |  | YES |  |  |
| level | int |  | YES |  |  |
| college_id | int | MUL | YES |  |  |
| is_delete | int(10) unsigned zerofill |  | YES | 0000000000 |  |

#### article(article)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| title | varchar(255) |  | YES |  |  |
| text | longtext |  | YES |  |  |
| admin_id | int | MUL | YES |  |  |
| create_time | datetime |  | YES |  |  |

#### colleges(colleges)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| name | varchar(255) |  | YES |  |  |
| max_person | int |  | YES |  |  |

#### comment(comment)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| article_id | int | MUL | YES |  |  |
| user_id | int | MUL | YES |  |  |
| text | varchar(255) |  | YES |  |  |
| create_time | timestamp |  | YES | CURRENT_TIMESTAMP |  |

#### fields(fields)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| name | varchar(255) |  | YES |  |  |
| max_person | int |  | YES |  |  |
| parent_id | int | MUL | YES |  |  |

#### games(games)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| game_name | varchar(255) |  | YES |  |  |
| next_game | int | MUL | YES |  |  |
| gender | int |  | YES |  |  |
| field_id | int | MUL | YES |  |  |
| max_person | int |  | YES |  |  |
| status | int |  | YES |  |  |
| start_time | datetime |  | YES |  |  |
| end_time | datetime |  | YES |  |  |
| create_time | datetime |  | YES |  |  |

#### menus(menus)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| name | varchar(255) |  | YES |  |  |
| icon | varchar(255) |  | YES |  |  |
| path | varchar(255) |  | YES |  |  |
| parent_id | int | MUL | YES |  |  |
| level_id | int | MUL | YES |  |  |

#### nums(nums)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| id_num | int |  | YES |  |  |
| college_id | int | MUL | YES |  |  |

#### registrations(registrations)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| game_id | int | MUL | YES |  |  |
| user_id | int | MUL | YES |  |  |
| status | int |  | YES |  |  |
| reviewer_id | int | MUL | YES |  |  |
| create_time | timestamp |  | YES |  |  |

#### reports(reports)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| game_id | int | MUL | YES |  |  |
| user_id | int | MUL | YES |  |  |
| create_time | datetime |  | YES |  |  |

#### site_allocation(site_allocation)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| user_id | int | MUL | YES |  |  |
| game_id | int | MUL | YES |  |  |
| field_id | int | MUL | YES |  |  |

#### user(user)
| 列名 | 类型 | KEY | 可否为空 | 默认值 | 注释 |
| ---- | ---- | ---- | ---- | ---- | ----  |
| id | int | PRI | NO |  |  |
| username | varchar(255) |  | YES |  |  |
| password | varchar(255) |  | YES |  |  |
| real_name | varchar(255) |  | YES |  |  |
| gender | int |  | YES |  |  |
| college_id | int | MUL | YES |  |  |
| create_time | datetime |  | YES |  |  |
| athletes_id | int | MUL | YES |  |  |
