insert into Region (id, name, description, image_path)
values (nextval('region_seq'), 'Speyside',
        'Geographically, Speyside is a region in Morayshire within the Highlands of Scotland. ' ||
        'For whisky purposes, it is distinguished as a sub-region of the Highlands due to the concentration' ||
        ' of distilleries in the area and some stylistic similarities between them. ', '/img/speyside.jpg');
insert into Region (id, name, description, image_path)
values (nextval('region_seq'), 'Highland',
        'To call Highland single malts diverse is an understatement: stretching from the Glasgow commuter ' ||
        'belt to the Pentland Firth and from the fertile east coast to the rugged west, this vast area boasts ' ||
        'a rich variety of distillery styles. From light and grassy to heavily sherried – these are whiskies that' ||
        ' refuse to be pigeonholed.', '/img/highland.jpg');
insert into Region (id, name, description, image_path)
values (nextval('region_seq'), 'Island',
        'Scotland’s labyrinthine archipelago of islands were obvious locations for distilleries, especially' ||
        ' at a time when illegal operations were the norm. Just a scattered handful of these far-flung facilities ' ||
        'remain now (excluding Islay) – although a few newcomers hint at an island distilling renaissance.',
        '/img/island.jpg');
insert into Region (id, name, description, image_path)
values (nextval('region_seq'), 'Islay',
        'Islay is best known for its disproportionately high number of distilleries – eight, with more planned – ' ||
        'and for a distinctively peaty style of single malt. Beyond the obvious lurks a surprising diversity of spirit, ' ||
        'making the identity of Islay whisky a more elusive prospect than might first appear.', '/img/islay.jpg');
insert into Region (id, name, description, image_path)
values (nextval('region_seq'), 'Lowland',
        'The Lowlands – like most of Scotland – were once a thriving hub of malt whisky production, until the need for' ||
        ' grain to drive blended Scotch production made making single malt an almost forgotten art. But a few outposts' ||
        ' preserve the old ways and a grassy, easy-drinking style of malt that still has many admirers.',
        '/img/lowland.jpg');
insert into Region (id, name, description, image_path)
values (nextval('region_seq'), 'Campbeltown',
        'Once a whisky boom town of 34 distilleries famed for their smoky, oily character, Campbeltown is quieter now, ' ||
        'with only three producers – and one of those only resurrected in 2004. Nonetheless, there are a number of styles ' ||
        'here, including peaty whiskies which are a reminder of Campbeltown’s illustrious past.',
        '/img/campbeltown.jpg');

insert into whisky(id, distillery, image_url, more_info, name, style, region_id, date_added)
values (nextval('whisky_seq'), 'Lagavulin',
        'https://cdn.whiskyshop.com/media/catalog/product/cache/50f391de93cd48dd70ebbdc71e96a683/l/a/lagavulin_8yo_ps.jpg',
        '2016 marks the 200th anniversary of one whiskies most loved distilleries - Lagavulin. To celebrate this remarkable milestone Lagavulin have launched a delightful limited edition bottle which is now available to order with The Whisky Shop. The inspiration behind the whisky - Back in the 1880''s Alfred Barnard (a world famous historian) visited the distillery and fell in love with an 8 year old expression which he described as ''exceptionally fine'' 200 years later Lagavulin have created a whisky to help celebrate the last 200 years and to recreate the character of the whisky enjoyed all those years ago. Matured using a combination of European and American Oak casks and bottled at 48% volume. Tasting notes Pale gold with faint green lights, American oak refill casks, light bodied. Powerfully phenolic, carbolic soap, backed by smouldering peat with bergamot; nose-drying and maritime (road salt, iodine). A thin texture, but a full-on Lagavulin taste: sweet, smoky, warming, with a very long finish and a lingering aftertaste of smoke.',
        'Lagavulin 8 Year Old', 'Single Malt', 4, '2021-09-12');
insert into whisky(id, distillery, image_url, more_info, name, style, region_id, date_added)
values (nextval('whisky_seq'), 'Oban',
        'https://cdn.whiskyshop.com/media/catalog/product/cache/50f391de93cd48dd70ebbdc71e96a683/o/b/oban_14yo_ss.jpg',
        'Fine single malt whisky has been made in Oban for over 200 years, in one of the oldest licensed distilleries in Scotland. In effect, the town grew up around the distillery and since its foundation in 1794 it has played a crucial role in local life. Oban is made using only the finest barley, malted to the distillery''s own particular specification. The tiny lantern-shaped copper pot stills are among the smallest in Scotland; their rich, fruity malt is then slowly condensed in wooden worm tubs that sit outside among the rooftops, before being aged in oak casks for at least 14 years.',
        'Oban 14 Year Old', 'Single Malt', 2, '	2021-09-12');
insert into whisky(id, distillery, image_url, more_info, name, style, region_id, date_added)
values (nextval('whisky_seq'), 'Caol Ila',
        'https://cdn.whiskyshop.com/media/catalog/product/cache/50f391de93cd48dd70ebbdc71e96a683/c/a/caol_ila_moch_ps.jpg',
        'Taking its name from the Gaelic for ''dawn'', Moch is a wonderful newcomer from the renowned Caol Ila distillery of island of Islay.It is the first single malt from Caol Ila to be selected for taste alone: sweet, smooth and lightly smoky, unconstrained by age, cask wood, strength or finish.',
        'Caol Ila Moch', 'Single Malt', 4, '2021-09-12');

insert into user(id, username, email, password)
values (nextval('user_seq'), 'johannes', 'johannes@johannes.be',
        '$2a$12$ycrQ7Pct/hXmLnxOSmjT0u5a.GUXj5CydgAyvmIpzfAV5PjIf6LKu');

insert into user(id, username, email, password)
values (nextval('user_seq'), 'roeder', 'roeder@roeder.be',
        '$2a$12$yH0pnhZX29DV3n15XjvIdOl0w3ua4mdlL/gjYOQ2Tn74mEGzS4bcS');

insert into user(id, username, email, password)
values (nextval('user_seq'), 'bert', 'bert@thomasmore.be',
        '$2a$12$xTuUzAqcoS5w.XoUGQ.zw.mOlwo0t0s3w279eMiei1j9KJfMsZCVS');

insert into user_whiskies(users_id, whiskies_id)
values (1, 1);
insert into user_whiskies(users_id, whiskies_id)
values (1, 2);
insert into user_whiskies(users_id, whiskies_id)
values (2, 1);
insert into user_whiskies(users_id, whiskies_id)
values (2, 3);
insert into user_whiskies(users_id, whiskies_id)
values (3, 1);
insert into user_whiskies(users_id, whiskies_id)
values (3, 2);
insert into user_whiskies(users_id, whiskies_id)
values (3, 3);