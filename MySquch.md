@SuppressWarnings("nls")
	public static void Squash(final String[] args) {
		final HashMap<String, Set<String>> signitureData = new HashMap<>();
		final Scanner scanner = new Scanner(System.in);

		scanner.forEachRemaining(inputString -> {
			final char[] signiture = inputString.toCharArray();
			Arrays.sort(signiture);
			signitureData.keySet().forEach(key -> {
				if (key.equals(String.valueOf(signiture))) {
					final Set<String> updatedSet = new TreeSet<>();
					updatedSet.addAll(signitureData.get(key));
					updatedSet.add(inputString);
					signitureData.put(key, updatedSet);
					foudnExistingSignitureFlag = true;
				}
			});
			if (!foudnExistingSignitureFlag) {
				final Set<String> updatedSet = new TreeSet<>();
				updatedSet.add(inputString);
				signitureData.put(String.valueOf(signiture), updatedSet);
				System.out.println(String.valueOf(signiture) + " " + inputString);
			} else {
				// System.out.println(String.valueOf(signiture) + " " +
				// signitureData.get(signiture).toString());
			}
			foudnExistingSignitureFlag = false;
		});
	}
