create table t_coffee (
    id bigint not null auto_increment,
    name varchar(255),
    price bigint not null,
    create_time datetime,
    update_time datetime,
    primary key (id)
);