JAK ZROBIC LISTVIEW

w mainactivititi

jakaslista =  new ArrayList<>();
arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, jakaslista);
listView = findViewById(R.id.jakisListVIew);
listView.setAdapter(arrayAdapter);
