insert into user_post (id, post_text, picture, link, username, post_date) values (1001, 'prvi post tekst', '',  'neki link', 'ana', '2020-12-08 17:11:31');
insert into user_post (id, post_text, picture, link, username, post_date) values (1002, 'drugi post tekst', '',  'link2', 'uki', '2020-12-08 17:11:32');
insert into user_post (id, post_text, picture, link, username, post_date) values (1003, 'treci post tekst', '',  'link3', 'ana', '2020-12-08 17:11:33');



insert into like_post (id, username, user_post) values (1001, 'ana', 1001 );



insert into dislike_post (id, username, user_post) values (1001, 'ana', 1002);



insert into comment (id, comment_text, username, user_post, comment_date) values (1003, 'nekikoment', 'ana', 1003, '2020-12-08 17:11:34');