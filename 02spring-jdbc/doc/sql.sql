create table t(
id int(11) not null auto_increment,
a int(11) default null,
b int(11) default null,
primary key(id)
)

insert into t(id,a,b) values (1,1,1),(2,2,2)